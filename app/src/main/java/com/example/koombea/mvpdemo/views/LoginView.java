package com.example.koombea.mvpdemo.views;

/**
 * Created by koombea on 28/01/16.
 */
public interface LoginView {
    void goToHomeScreen();

    void showUsernameError();

    void showPasswordError();

    void displayProgress();

    void hideProgress();


}
