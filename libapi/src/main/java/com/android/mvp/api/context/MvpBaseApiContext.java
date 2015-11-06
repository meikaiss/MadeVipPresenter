package com.android.mvp.api.context;

import com.android.mvp.core.MvpCore;
import com.android.mvp.core.context.BaseApiContext;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.utils.MvpUtils;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class MvpBaseApiContext<A, T> extends BaseApiContext<A, T> {


    public MvpBaseApiContext(A a) {
        super(a);
    }

    @Override
    public T request() throws Exception {
        return null;
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
