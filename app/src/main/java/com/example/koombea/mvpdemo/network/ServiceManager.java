package com.example.koombea.mvpdemo.network;

import android.util.Log;

import com.example.koombea.mvpdemo.model.User;
import com.example.koombea.mvpdemo.model.error.ApiError;
import com.example.koombea.mvpdemo.presenter.OnLoginCallback;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by koombea on 28/01/16.
 */
public class ServiceManager {

    private static final String TAG = ServiceManager.class.getSimpleName();

    public static void loginRequest(final String username, String password, final OnLoginCallback callback) {
        ParseService service = ServiceGenerator.createService(ParseService.class);


        service.doLogin(username, password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                if(response.isSuccess()){
                    response.body().getUsername();
                    callback.onSuccess();
                }
                else{
                    ApiError error = ErrorUtils.parseError(response);
                    Log.d(TAG,"Error code : "+error.getError());
                    callback.onUsernameError();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        }


    }
