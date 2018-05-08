package com.zone.androidtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zone.androidtest.algorithm.SearchTest;
import com.zone.androidtest.finaltest.JavaConstantTest;
import com.zone.androidtest.volley.VolleyManager;

import java.io.File;

/**
 * Created by p_zoneguo on 2018/4/10.
 */

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

}
