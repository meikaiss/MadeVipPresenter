package com.android.mvp.api.base;

import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

/**
 * Created by meikai on 15/11/24.
 */
public abstract class MvpRequestBaseApi<T> extends MvpBaseApi {

    public abstract T request() throws ApiException, HttpException, InternalException;

}
