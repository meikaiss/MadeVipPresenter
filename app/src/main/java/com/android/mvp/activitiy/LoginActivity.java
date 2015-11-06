package com.android.mvp.activitiy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.android.mvp.R;
import com.android.mvp.api.dto.LoginDto;
import com.android.mvp.core.utils.MvpUtils;
import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.presenter.impl.LoginPresenterImpl;
import com.android.mvp.uiinterface.LoginUI;

public class LoginActivity extends AppCompatActivity implements LoginUI, View.OnClickListener {

    private LoginPresenter loginPresenter;

    private EditText edtUserName;
    private EditText edtUserPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtUserPwd = (EditText) findViewById(R.id.edt_user_pwd);

        loginPresenter = new LoginPresenterImpl(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loginSuccess() {
        MvpUtils.showToast("调用成功");

    }

    @Override
    public void loginFailed() {

        MvpUtils.showToast("调用失败");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginPresenter.login(new LoginDto(edtUserName.getText().toString(), edtUserPwd.getText().toString()));
                break;
            default:
                break;
        }
    }
}
