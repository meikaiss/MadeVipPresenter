package com.android.mvp.api.context;

import android.app.Activity;

import com.android.mvp.core.MvpCore;
import com.android.mvp.core.context.BaseActivityApiContext;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.utils.MvpUtils;

/**
 * Created by meikai on 15/11/21.
 */
public abstract class MvpActivityBaseApiContext extends BaseActivityApiContext {

    public MvpActivityBaseApiContext(Activity activity) {
        super(activity);
    }

    @Override
    public void onApiFailure(Exception exception) {
        if (exception instanceof HttpException) {
            MvpCore.postOnUiThread(new Runnable() {
                @Override
                public void run() {
                    MvpUtils.showToast("网络错误，请检查网络");
                }
            });
        } else if (exception instanceof ApiException) {
            final ApiException apiException = (ApiException) exception;
            MvpCore.postOnUiThread(new Runnable() {
                @Override
                public void run() {
                    MvpUtils.showToast("(" + apiException.getErrorCode() + ") " + apiException.getMessage());
                }
            });
        }
    }
}

