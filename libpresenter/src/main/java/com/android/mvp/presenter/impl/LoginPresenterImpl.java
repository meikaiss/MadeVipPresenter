package com.android.mvp.presenter.impl;

import android.app.Activity;

import com.android.mvp.api.LoginApi;
import com.android.mvp.api.dto.LoginDto;
import com.android.mvp.api.impl.LoginApiImpl;
import com.android.mvp.core.context.ApiUtils;
import com.android.mvp.core.context.BaseApiContext;
import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.uiinterface.LoginUI;

/**
 * Created by meikai on 15/11/6.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private Activity activity;
    private LoginUI loginUI;


    public LoginPresenterImpl(Activity activity, LoginUI loginUI) {
        this.activity = activity;
        this.loginUI = loginUI;
    }

    @Override
    public void login(LoginDto loginDto) {

        ApiUtils.apiRequest(new LoginApiContext(activity, loginUI, loginDto));

    }

    private static class LoginApiContext extends BaseApiContext<Activity, Boolean>{

        private LoginUI loginUI;
        private LoginApi loginApi;
        private LoginDto loginDto;

        public LoginApiContext(Activity activity, LoginUI loginUI, LoginDto loginDto) {
            super(activity);
            this.loginUI = loginUI;
            this.loginDto = loginDto;
            this.loginApi = new LoginApiImpl();
        }

        @Override
        public Boolean request() throws Exception {
            return loginApi.login(this.loginDto);
        }

        @Override
        public void onApiSuccess(Boolean boolBoolean) {
            Activity activity = get();
            if(activity != null){
                if(boolBoolean)
                    loginUI.loginSuccess();
                else
                    loginUI.loginFailed();
            }
        }

        @Override
        public void onApiFailure(Exception exception) {
            super.onApiFailure(exception);
            Activity activity = get();
            if(activity != null){
                loginUI.loginFailed();
            }
        }
    }

}
