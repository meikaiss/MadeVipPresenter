package com.android.mvp.core.http;

import com.android.mvp.core.utils.MvpUtils;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by meikai on 15/11/7.
 */
public class MvpHttpClient {

    private static MvpHttpClient instance;

    private OkHttpClient okHttpClient = new OkHttpClient();

    public static MvpHttpClient getInstance(){
        if(instance== null){
            synchronized (MvpHttpClient.class){
                if(instance == null){
                    instance = new MvpHttpClient();
                }
            }
        }
        return instance;
    }


    public String httpGet(String url) throws IOException {
        return this.httpGet(url, null);
    }

    private String httpGet(String url, List<MvpNameValuePair> pairList) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();

        if(MvpUtils.isEmpty(pairList)){
            HttpUrl httpUrl = HttpUrl.parse(url);
            HttpUrl.Builder urlBuilder = httpUrl.newBuilder();

            Iterator i$ = pairList.iterator();
            while (i$.hasNext()){
                MvpNameValuePair pair = (MvpNameValuePair) i$.next();
                urlBuilder.addQueryParameter(pair.getName(), pair.getValue());
            }

            httpUrl = urlBuilder.build();
            requestBuilder.url(httpUrl);
        }else{
            requestBuilder.url(url);
        }

        String responseString = toString(requestBuilder);

        return responseString;
    }

    private String toString(Request.Builder requestBuilder) throws IOException {
        return toString(requestBuilder, "utf-8");
    }

    private String toString(Request.Builder requestBuilder, String encoding) throws IOException{
        byte[] bytes = toBytes(requestBuilder);

        return  bytes == null? null : new String(bytes, encoding);
    }

    private byte[] toBytes(Request.Builder requestBuilder) throws IOException{
        Response response = okHttpClient.newCall(requestBuilder.build()).execute();

        return decodeToBytes(response);
    }

    private byte[] decodeToBytes(Response response) throws IOException {
        byte[] bodyData = response.body().bytes();

        return bodyData;
    }

}
