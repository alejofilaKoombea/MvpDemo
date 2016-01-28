package com.example.koombea.mvpdemo.presenter;

/**
 * Created by koombea on 28/01/16.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
