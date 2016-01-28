package com.example.koombea.mvpdemo.network;

import com.example.koombea.mvpdemo.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by koombea on 28/01/16.
 */
public interface ParseService {
    @Headers({
            "X-Parse-Application-Id: VyI8pUVbCdUUUmR9GoCduOlM8ZRG3Dzd10MBINvr",
            "X-Parse-REST-API-Key: dmMGWyPG2HLj6KoRuoZOAUxevmI6wjEOgwoQhqnQ"})

    @GET("login/")
    Call<User> doLogin(@Query("username") String username, @Query("password") String password);
}
