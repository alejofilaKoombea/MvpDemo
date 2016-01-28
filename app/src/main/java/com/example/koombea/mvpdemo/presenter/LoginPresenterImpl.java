package com.example.koombea.mvpdemo.presenter;

import com.example.koombea.mvpdemo.interactor.LoginInteractor;
import com.example.koombea.mvpdemo.interactor.LoginInteractorImpl;
import com.example.koombea.mvpdemo.views.LoginView;

/**
 * Created by koombea on 28/01/16.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginCallback{


    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        view.displayProgress();
        interactor.doLogin(username,password,this);
    }

    @Override
    public void onDestroy() {
        this.view = null;

    }

    @Override
    public void onUsernameError() {
        view.hideProgress();
        view.showUsernameError();

    }

    @Override
    public void onPasswordError() {
        view.hideProgress();
        view.showPasswordError();

    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.goToHomeScreen();

    }
}
