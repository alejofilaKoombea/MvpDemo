package com.example.koombea.mvpdemo.presenter;

/**
 * Created by koombea on 28/01/16.
 */
public interface OnLoginCallback {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();


}
