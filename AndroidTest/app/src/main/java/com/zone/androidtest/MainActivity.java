package com.zone.androidtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zone.androidtest.algorithm.SearchTest;
import com.zone.androidtest.finaltest.JavaConstantTest;
import com.zone.androidtest.volley.VolleyManager;

import java.io.File;

/**
 * Created by p_zoneguo on 2018/4/10.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initUI();

        test1();
//        test2();
        test3();
        VolleyManager.getInstance().request1();
    }

    private void test1() {
        int [] inputs = new int[]{10, 8, 7, 1, 2, 4, 3, 5, 6, 9};
        int [] ouputs = SearchTest.calculate(inputs);
        for (int i = 0; i < ouputs.length; i++) {
            Log.d(TAG, inputs[i] + "-" + ouputs[i]);
        }
    }

    private void test2() {
        Intent intent = new Intent();
        intent.setClass(this, com.zone.androidtest.algorithm.MainActivity.class);
        startActivity(intent);
    }

    private void test3() {
        File dir = getDir("app", Context.MODE_PRIVATE);
        Log.d(TAG, "[test3] dir = " + dir);
    }

    private void test4() {
        Log.d(TAG, "[test4] CONSTANT1 = " + JavaConstantTest.CONSTANT1);
        Log.d(TAG, "[test4] CONSTANT = " + JavaConstantTest.sContant);
    }

    private void initUI() {
        initBtn();
    }

    private void initBtn() {
        mBtn = findViewById(R.id.button);
        mBtn.setOnClickListener(this);
        mBtn.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
    }

    /**
     *对于外部拦截法，需要重写父View的onInterceptTouchEvent方法
     */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /**
                 * 这里必须返回false，因为对于DOWN事件，一旦拦截，
                 * 后续的事件就不会调用onInterceptTouchEvent方法。
                 * 对于外部拦截法，也就是先让子View进行处理事件
                 */
                intercepted = false;
                break;

            case MotionEvent.ACTION_MOVE:
                if (needIntercept(event)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }

        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercepted;
    }

    private boolean needIntercept(MotionEvent event) {
        return false;
    }

    /**
     * 内部拦截法是指父容器不拦截任何事件，所有的事件都传递子元素，如果子元素需要次事件
     * 就直接消耗掉，否则就交给父容器进行处理。
     */
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                parent.requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                if (父类需要此类点击事件) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        mLastX = x;
        mLastY = y;

        return super.dispatchTouchEvent();
    }

}
