package com.android.mvp.core.api;

import com.alibaba.fastjson.JSONObject;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.http.MvpHttpClient;
import com.android.mvp.core.http.MvpNameValuePair;
import com.android.mvp.core.utils.MvpUrlParamUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaseApi {

    protected abstract String getProtocol();

    protected abstract String getApiHost();

    protected abstract String getSignKey();

    protected Map<String, String> getExtraParams() {
        return null;
    }


    protected ApiResponse httpGet(String url) throws ApiException, HttpException, InternalException {
        url = buildFullUrl(url);

        try {
            String jsonString = MvpHttpClient.getInstance().httpGet(url);
//            jsonString = "{\"data\":true,\"errorCode\":0,\"message\":0,\"success\":true}";

            JSONObject httpJsonObject = JSONObject.parseObject(jsonString);
            ApiResponse response = new ApiResponse(httpJsonObject);
            handlerResponse(response);

            return  response;
        } catch (IOException e) {
            throw new HttpException("网络信号不太好");
        } catch (ApiException apiException){
            throw apiException;
        } catch (Exception exception){
            throw new InternalException(exception);
        }
    }

    protected ApiResponse httpPost(String url) throws ApiException, HttpException, InternalException {

        List<MvpNameValuePair> pairList = null;
        return httpPost(url, pairList);
    }

    protected ApiResponse httpPost(String url, List<MvpNameValuePair> pairList) throws ApiException, HttpException, InternalException {

        url = buildFullUrl(url);

        try {
            String jsonString = MvpHttpClient.getInstance().httpPost(url, pairList);
            jsonString = "{\"data\":true,\"errorCode\":0,\"message\":0,\"success\":true}";

            JSONObject httpJsonObject = JSONObject.parseObject(jsonString);
            ApiResponse response = new ApiResponse(httpJsonObject);
            handlerResponse(response);

            return  response;
        } catch (IOException e) {
            throw new HttpException("网络信号不太好");
        } catch (ApiException apiException){
            throw apiException;
        } catch (Exception exception){
            throw new InternalException(exception);
        }

    }

    protected ApiResponse httpPost(String url, byte[] body) throws ApiException, HttpException, InternalException {

        url = buildFullUrl(url);

        try {
            String jsonString = MvpHttpClient.getInstance().httpPostBody(url, body);

            JSONObject httpJsonObject = JSONObject.parseObject(jsonString);
            ApiResponse response = new ApiResponse(httpJsonObject);
            handlerResponse(response);

            return  response;
        } catch (IOException e) {
            throw new HttpException("网络信号不太好");
        } catch (ApiException apiException){
            throw apiException;
        } catch (Exception exception){
            throw new InternalException(exception);
        }

    }


    protected String buildFullUrl(String url){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProtocol());
        stringBuilder.append(this.getApiHost());
        stringBuilder.append(MvpUrlParamUtils.buildUrlParams(url, this.getExtraParams(), getSignKey()));

        return  stringBuilder.toString();
    }

    private void handlerResponse(ApiResponse apiResponse) throws ApiException{
        if(!apiResponse.isSuccess()){
            throw new ApiException(apiResponse.getErrorCode(), apiResponse.getMessage());
        }
    }

    public enum HttpMethod{
        Post,
        Get;

        private HttpMethod(){

        }
    }

}
