package com.android.mvp.core.http;

import com.android.mvp.core.utils.MvpUtils;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
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

    private String userAgent;

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

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


    public Request.Builder prepareBuilder() {
        Request.Builder builder = new Request.Builder();
        this.addDefaultHeader(builder);
        return builder;
    }

    private void addDefaultHeader(Request.Builder builder) {
        String agent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 3.5.21022;)";
        if(MvpUtils.isNotEmpty(this.userAgent)) {
            agent = this.userAgent;
        }

        builder.header("User-Agent", agent);
        builder.header("User-Platform", "Android");
        builder.header("User-AppName", MvpUtils.safeURLEncode("your app's name", "UTF-8"));
        builder.header("Accept-Encoding", "gzip");
    }

    public String httpPostBody(String url, byte[] body) throws IOException {
        return this.httpPostBody(url, body, "application/octet-stream");
    }

    private static String trimToEmpty(String s) {
        return MvpUtils.isEmpty(s)?"":s;
    }

    public String httpPostBody(String url, byte[] body, String contentType) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.post(RequestBody.create(MediaType.parse(contentType), body));

        try {
            return this.toString(builder);
        } catch (Exception var6) {
            var6.printStackTrace();
            throw new IOException("网络连接失败");
        }
    }

    public String httpPost(String url, List<MvpNameValuePair> list) throws IOException {
        Request.Builder builder = this.prepareBuilder();
        builder.url(url);
        FormEncodingBuilder encodingBuilder = new FormEncodingBuilder();
        Iterator ex = list.iterator();

        while(ex.hasNext()) {
            MvpNameValuePair pair = (MvpNameValuePair)ex.next();
            encodingBuilder.add(pair.getName(), trimToEmpty(pair.getValue()));
        }

        builder.post(encodingBuilder.build());

        try {
            String ex1 = this.toString(builder);
            return ex1;
        } catch (Exception var7) {
            var7.printStackTrace();
            throw new IOException("网络连接失败");
        }
    }

}
