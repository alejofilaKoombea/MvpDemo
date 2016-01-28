package com.example.koombea.mvpdemo.views.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.koombea.mvpdemo.R;
import com.example.koombea.mvpdemo.presenter.LoginPresenter;
import com.example.koombea.mvpdemo.presenter.LoginPresenterImpl;
import com.example.koombea.mvpdemo.views.LoginView;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    private LoginPresenter presenter;

    @Bind(R.id.txtUsername)
    EditText txtUsername;
    @Bind(R.id.txtPassword)
    EditText txtPassword;
    @Bind(R.id.progressLogin)
    ProgressBar progressBar;
    @Bind(R.id.btnLogin)
    Button btnLogin;


    //Activty methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpView();
        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    //Login view methods
    @Override
    public void goToHomeScreen() {
        Toast.makeText(this,"Login succesful",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUsernameError() {
        Toast.makeText(this,R.string.error_username,Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public void showPasswordError() {
        Toast.makeText(this,R.string.error_password,Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public void displayProgress() {
        btnLogin.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        btnLogin.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

    }

    @OnClick(R.id.btnLogin)
    public void performLogin() {
        presenter.validateCredentials(txtUsername.getText().toString(), txtPassword.getText().toString());

    }
}


