package utils.http;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import base.Request;
import base.RequestImage;
import base.RequestType;
import common.Constant;
import utils.io.BitmapCache;
import utils.json.JSONUtils;
import utils.system.LogUtils;

/**
 * 项目名称：com.utils.http
 * 类描述  网络请求
 * 创建人：Darker
 * 邮箱：1522651962@qq.com
 * 创建时间：15/9/14 下午1:32
 * 修改备注：
 *
 * @version 1.0
 */
public class HttpRequest {
    private static final int TIMEOUT = 3000;//连接超时30s
    private static final int RETRYCOUNT = 0;//网络不稳定发送请求次数
    private static final String FILE_KEY="file";

    public static void request(Request request) {
        RequestType requestType = request.getRequestType();
        switch (requestType) {
            case POST:
                post(request);
                break;
            case GET:
                get(request);
                break;
            case UPLOAD:
                //upload(request);
                break;
            case DOWNIMAGE:
                downImage(request);
                break;
            case MULTIPART:
                multipart(request);
                break;

        }
    }

    /**
     * POST 方式
     *
     * @param request
     */
    private static void post(final Request request) {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST,
                request.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LogUtils.v("request", response);
                request.getiRequestFromController().requestSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
                if (error instanceof TimeoutError) {
                    request.getiRequestFromController().requestTimeout(error.toString());
                }
                if (error instanceof ServerError) {
                    request.getiRequestFromController().requestServerError(error.toString());
                }
                if (error instanceof NoConnectionError){
                    request.getiRequestFromController().requestNoConnection(error.toString());

                }
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                LogUtils.v("json=", JSONUtils.objectToString(request.getParameter()));
                params.put(Constant.PARAMETER_KEY, JSONUtils.objectToString(request.getParameter()));
                return params;
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT, RETRYCOUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        request.getQueue().add(stringRequest);

    }

    /**
     * GET 方式
     *
     * @param request
     */
    private static void get(final Request request) {
        request.getQueue().add(new JsonObjectRequest(com.android.volley.Request.Method.GET, request.getUrl(), new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                request.getiRequestFromController().requestSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError) {
                    request.getiRequestFromController().requestTimeout(error.toString());
                }
                if (error instanceof ServerError) {
                    request.getiRequestFromController().requestServerError(error.toString());
                }
                if (error instanceof NoConnectionError){
                    request.getiRequestFromController().requestNoConnection(error.toString());

                }

            }
        }).setRetryPolicy(new DefaultRetryPolicy(TIMEOUT, RETRYCOUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        request.getQueue().start();

    }

    /**
     * 加载图片
     *
     * @param request
     */
    public static void downImage(final Request request) {
        RequestImage requestImage = (RequestImage) request;
        ImageLoader imageLoader = new ImageLoader(requestImage.getQueue(), new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(requestImage.getImageView(),
                requestImage.getDefaultImage(), requestImage.getFailureImage());
        imageLoader.get(requestImage.getUrl(), listener);

    }

    /**
     * multipart 方式 post
     *
     * @param request
     */
    private static void multipart(final Request request) {
        AsyncHttpPost post = new AsyncHttpPost(request.getUrl());
        post.setTimeout(TIMEOUT);
        MultipartFormDataBody body = new MultipartFormDataBody();
        for (int i = 0; i < request.getPaths().size(); i++) {
            body.addFilePart(FILE_KEY+ i, new File(request.getPaths().get(i)));
        }
        body.addStringPart(Constant.PARAMETER_KEY, JSONUtils.objectToString(request.getParameter()));
        post.setBody(body);
        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(Exception e, AsyncHttpResponse source, String result) {
                if (e == null) {
                    if (source.code() == 200) {
                        request.getiRequestFromController().requestSuccess(result);
                    } else {
                        request.getiRequestFromController().requestServerError(result);
                    }
                } else {
                        request.getiRequestFromController().requestServerError(e.toString());
                }

            }
        });


    }
}
