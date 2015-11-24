package com.android.mvp.core;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by meikai on 15/11/4.
 */
public class MvpCore {

    /**
     * 线程池数量
     */
    private static final int iThreadCount = 10;

    private static Application application;

    public static Application getApplication() {
        return application;
    }

    private static ExecutorService es;
    private static Handler handler;

    private static WeakReference<Activity> currentActivity;


    public static void init(Application applicationInstance) {
        application = applicationInstance;
        es = Executors.newFixedThreadPool(iThreadCount);

        handler = new Handler(Looper.getMainLooper());
    }

    public static void postOnUiThread(Runnable task) {
        handler.post(task);
    }

    public static void postOnUiThreadDelay(Runnable task, long delay) {
        handler.postDelayed(task, delay);
    }

    public static void execute(Runnable task) {
        es.execute(task);
    }

    static void setCurrentActivity(Activity activity) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    public static Activity getCurrentActivity() {
        return currentActivity != null ? currentActivity.get() : null;
    }


}
