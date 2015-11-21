package com.android.mvp.activitiy;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.mvp.R;
import com.android.mvp.core.context.BaseActivityApiContext;

/**
 * Created by meikai on 15/11/21.
 */
public class ActivityApiTestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_api_test);


        Dialog dialog = new Dialog(this);
        dialog.setTitle("这里测试");
        dialog.show();

        finish();
    }

    @Override
    public void onClick(View v) {

        Dialog dialog = new Dialog(this);
        dialog.setTitle("这里测试");
        dialog.show();

        finish();
    }


    private static final class GetNewsListApiContext extends BaseActivityApiContext<Activity, Object>{



        public GetNewsListApiContext(Activity activity) {
            super(activity);
        }

        @Override
        public Object request() throws Exception {
            return null;
        }

        @Override
        public void onApiSuccess(Object var1) {

        }

    }

}
