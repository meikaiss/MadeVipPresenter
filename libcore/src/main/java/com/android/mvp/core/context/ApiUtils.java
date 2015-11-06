package com.android.mvp.core.context;

import android.os.Looper;

import com.android.mvp.core.MvpCore;

/**
 * Created by meikai on 15/11/4.
 */
public class ApiUtils {

    public static <T> void apiRequest(final ApiContext<T> apiContext) {

        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            apiContext.onApiStarted();
            doApiRequest(apiContext);
        } else {
            MvpCore.postOnUiThread(new Runnable() {
                @Override
                public void run() {
                    apiContext.onApiStarted();
                    ApiUtils.doApiRequest(apiContext);
                }
            });
        }

    }


    private static <T> void doApiRequest(final ApiContext<T> apiContext) {
        MvpCore.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final T result = apiContext.request();

                    MvpCore.postOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                apiContext.onApiSuccess(result);   // ???? 这里为什么会 发生 弱引用 丢失
                            } catch (WeakRefLostException weakRefLostException) {
                                weakRefLostException.printStackTrace();
                            }
                        }
                    });


                } catch (final Exception e) {
                    e.printStackTrace();
                    if (!(e instanceof WeakRefLostException)) {
                        MvpCore.postOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    apiContext.onApiFailure(e);
                                } catch (WeakRefLostException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        return;
                    }
                } finally {
                    MvpCore.postOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                apiContext.onApiFinished();
                            }catch (WeakRefLostException e){
                                e.printStackTrace();
                            }
                        }
                    });
                }

            }
        });
    }

}
