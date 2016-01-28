package com.example.koombea.mvpdemo.interactor;

import com.example.koombea.mvpdemo.presenter.OnLoginCallback;

/**
 * Created by koombea on 28/01/16.
 */
public interface LoginInteractor {
    void doLogin(String username, String password, OnLoginCallback callback);
}
