package com.android.mvp;

import android.app.Application;

import com.android.mvp.core.MvpCore;

/**
 * Created by meikai on 15/11/6.
 */
public class MvpApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        MvpCore.init(this);


    }
}
