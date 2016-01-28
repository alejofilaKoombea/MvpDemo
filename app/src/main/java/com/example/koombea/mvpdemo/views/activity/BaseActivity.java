package com.example.koombea.mvpdemo.views.activity;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by koombea on 28/01/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public void setUpView() {
        setContentView(getContentView());
        ButterKnife.bind(this);

    }

    public abstract int getContentView();

}
