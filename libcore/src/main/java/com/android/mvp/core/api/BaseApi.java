package com.android.mvp.core.api;

import com.alibaba.fastjson.JSONObject;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.http.MvpNameValuePair;
import com.android.mvp.core.utils.MvpUrlParamUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaseApi {

    protected abstract String getApiHost();

    protected abstract String getSignKey();

    protected Map<String, String> getExtraParams() {
        return null;
    }


    protected ApiResponse httpGet(String url) throws ApiException, HttpException, InternalException {
        url = buildFullUrl(url);

        ApiResponse response = new ApiResponse(null);

        return  response;
    }

    protected ApiResponse httpPost(String url, List<MvpNameValuePair> pairList) throws ApiException, HttpException, InternalException {
        url = buildFullUrl(url);


        JSONObject httpJsonObject = JSONObject.parseObject("{\"data\":false,\"errorCode\":0,\"message\":0,\"success\":false}");

        ApiResponse response = new ApiResponse(httpJsonObject);

        return  response;
    }



    protected String buildFullUrl(String url){

        return this.getApiHost() + MvpUrlParamUtils.buildUrlParams(url, this.getExtraParams(), getSignKey());
    }



    public static enum HttpMethod{
        Post,
        Get;

        private HttpMethod(){

        }
    }

}
