package com.example.koombea.mvpdemo.interactor;


import com.example.koombea.mvpdemo.network.ServiceManager;
import com.example.koombea.mvpdemo.presenter.OnLoginCallback;



/**
 * Created by koombea on 28/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {


    private static final String TAG = LoginInteractorImpl.class.getSimpleName();

    @Override
    public void doLogin(final String username, String password, final OnLoginCallback callback) {
        ServiceManager.loginRequest(username, password, callback);
    }
}
