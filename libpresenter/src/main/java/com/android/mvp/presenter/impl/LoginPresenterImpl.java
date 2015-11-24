package com.android.mvp.presenter.impl;

import android.content.Context;

import com.android.mvp.api.context.MvpBaseApiContext;
import com.android.mvp.api2.LoginApi;
import com.android.mvp.api2.po.UserInfo;
import com.android.mvp.core.context.ApiUtils;
import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.uiinterface.LoginUI;

/**
 * Created by meikai on 15/11/6.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private Context context;
    private LoginUI loginUI;

    public LoginPresenterImpl(Context context, LoginUI loginUI) {
        this.context = context;
        this.loginUI = loginUI;
    }

    @Override
    public void login(String userName, String userPwd) {
        ApiUtils.apiRequest(new LoginApiContext(this, userName, userPwd));
    }


    private static final class LoginApiContext extends MvpBaseApiContext<LoginPresenterImpl, UserInfo> {

        private LoginApi loginApi;
        private String userName;
        private String userPwd;

        public LoginApiContext(LoginPresenterImpl loginPresenter, String userName, String userPwd) {
            super(loginPresenter);
            this.userName = userName;
            this.userPwd = userPwd;
            this.loginApi = new LoginApi(userName, userPwd);
        }

        @Override
        public UserInfo request() throws Exception {
            return this.loginApi.request();
        }

        @Override
        public void onApiSuccess(UserInfo var1) {
            LoginPresenterImpl loginPresenter = get();
            if (loginPresenter != null) {
                loginPresenter.loginUI.loginSuccess(var1);
            }
        }

        @Override
        public void onApiFailure(Exception exception) {
            super.onApiFailure(exception);
            LoginPresenterImpl loginPresenter = get();
            if (loginPresenter != null) {
                loginPresenter.loginUI.loginFailed();
            }
        }

    }

}
