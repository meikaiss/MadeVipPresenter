package com.android.mvp.api2.base;

import com.android.mvp.api.base.MvpRequestBaseApi;

/**
 * Created by meikai on 15/11/24.
 */
public abstract class DemoRequestBaseApi<T> extends MvpRequestBaseApi<T> {

    @Override
    protected String getProtocol() {
        return "http://";
    }

    @Override
    protected String getApiHost() {
        return "192.168.1.100";
    }

    @Override
    protected String getSignKey() {
        return "coder";
    }

}
