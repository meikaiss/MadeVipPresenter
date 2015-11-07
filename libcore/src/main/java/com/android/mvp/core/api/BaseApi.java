package com.android.mvp.core.api;

import com.alibaba.fastjson.JSONObject;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.http.MvpNameValuePair;
import com.android.mvp.core.utils.MvpUrlParamUtils;
import com.android.mvp.core.utils.MvpUtils;

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

        handlerResponse(response);

        return  response;
    }

    protected ApiResponse httpPost(String url, List<MvpNameValuePair> pairList) throws ApiException, HttpException, InternalException {
        url = buildFullUrl(url);

        MvpUtils.showToastInThread(url);

        String jsonString = "{\"data\":true,\"errorCode\":0,\"message\":0,\"success\":true}";

        JSONObject httpJsonObject = JSONObject.parseObject(jsonString);

        ApiResponse response = new ApiResponse(httpJsonObject);

        handlerResponse(response);

        return  response;
    }



    protected String buildFullUrl(String url){

        return this.getApiHost() + MvpUrlParamUtils.buildUrlParams(url, this.getExtraParams(), getSignKey());
    }

    private void handlerResponse(ApiResponse apiResponse) throws ApiException{
        if(!apiResponse.isSuccess()){
            throw new ApiException(apiResponse.getErrorCode(), apiResponse.getMessage());
        }
    }



    public static enum HttpMethod{
        Post,
        Get;

        private HttpMethod(){

        }
    }

}
