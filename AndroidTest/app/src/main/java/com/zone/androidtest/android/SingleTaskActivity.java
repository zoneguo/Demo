package com.zone.androidtest.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zone.androidtest.R;

public class SingleTaskActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }
}
