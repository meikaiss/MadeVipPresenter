package com.android.mvp.api2;

import com.android.mvp.api2.base.DemoRequestBaseApi;
import com.android.mvp.api2.po.UserInfo;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.http.MvpNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meikai on 15/11/24.
 */
public class LoginApi extends DemoRequestBaseApi<UserInfo> {

    private String userName;
    private String userPwd;


    public LoginApi(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public UserInfo request() throws ApiException, HttpException, InternalException {

        List<MvpNameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new MvpNameValuePair("userName", userName));
        nameValuePairList.add(new MvpNameValuePair("userPwd", userPwd));

        return httpPostData(ApiUrlConstant.LOGIN_IN, nameValuePairList, UserInfo.class);
    }

}
