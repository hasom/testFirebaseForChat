package com.hasom.testfirebase;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leejunho on 2017. 4. 16..
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnChat)
    public void onClickChat() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @OnClick(R.id.btnAuthForEmail)
    public void onClickAuth() {
        startActivity(new Intent(this, EmailPasswordActivity.class));
    }

}
