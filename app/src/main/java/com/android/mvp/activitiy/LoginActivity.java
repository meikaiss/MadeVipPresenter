package com.android.mvp.activitiy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mvp.R;
import com.android.mvp.api2.po.UserInfo;
import com.android.mvp.base.MvpBaseActivity;
import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.presenter.impl.LoginPresenterImpl;
import com.android.mvp.uiinterface.LoginUI;

public class LoginActivity extends MvpBaseActivity implements LoginUI, View.OnClickListener {

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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginPresenter.login(edtUserName.getText().toString(), edtUserPwd.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {
        Toast.makeText(getContext(), "登录成功", Toast.LENGTH_LONG).show();

    }

    @Override
    public void loginFailed() {
        Toast.makeText(getContext(), "登录失败", Toast.LENGTH_LONG).show();

    }
}
