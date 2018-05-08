package com.zone.androidtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by p_zoneguo on 2018/5/7.
 */

public class MyApplication extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
