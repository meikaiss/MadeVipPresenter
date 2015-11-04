package com.android.mvp.core.api;

import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaesApi {


    protected ApiResponse httpGet(String url) throws ApiException, HttpException, InternalException {


        ApiResponse response = new ApiResponse(null);

        return  response;
    }
}
