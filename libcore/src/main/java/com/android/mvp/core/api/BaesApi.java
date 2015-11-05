package com.android.mvp.core.api;

import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaesApi {

    protected abstract String getApiHost();

    protected abstract String getSignKey();


    protected ApiResponse httpGet(String url) throws ApiException, HttpException, InternalException {


        ApiResponse response = new ApiResponse(null);

        return  response;
    }

    protected String buildFullUrl(String url){
        StringBuilder sb = new StringBuilder(url);

        HashMap hashMap = new HashMap();
        hashMap.put("_r", UUID.randomUUID().toString().replaceAll("-", ""));



        return this.getApiHost() + sb.toString();
    }

    public static enum HttpMethod{
        Post,
        Get;

        private HttpMethod(){

        }
    }
}
