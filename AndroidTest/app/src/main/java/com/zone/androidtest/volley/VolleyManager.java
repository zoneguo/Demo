package com.zone.androidtest.volley;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zone.androidtest.MyApplication;

public class VolleyManager {
    private static final String TAG = "VolleyManager";

    private RequestQueue mRequestQueue;

    private static final String URL_QQ = "http://www.qq.com";

    private VolleyManager() {
        init();
    }

    private static final class SingletonHolder {
        private static final VolleyManager INSTANCE = new VolleyManager();
    }

    public static VolleyManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private void init() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.sContext);
    }

    /**
     * 1. 回调是在主线程运行的
     * 2. cancel中的TAG真的很好用
     */
    public void request1() {
        StringRequest strRequest = new StringRequest(Request.Method.GET, URL_QQ,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "[onResponse] response = " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "[onErrorResponse] error = " + error.toString());
                    }
                });

        mRequestQueue.add(strRequest);
    }


}
