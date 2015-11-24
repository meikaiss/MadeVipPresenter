package com.android.mvp.uiinterface;

import com.android.mvp.api2.po.UserInfo;
import com.android.mvp.base.BaseUI;

/**
 * Created by meikai on 15/11/6.
 */
public interface LoginUI extends BaseUI {

    void loginSuccess(UserInfo userInfo);

    void loginFailed();

}
