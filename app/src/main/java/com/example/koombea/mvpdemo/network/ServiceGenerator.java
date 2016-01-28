package com.example.koombea.mvpdemo.network;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by koombea on 28/01/16.
 */
public class ServiceGenerator {


    private static OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit.Builder getRetrofitBuilder(){
        return retrofitBuilder;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, NetworkConstants.BASIC_AUTH_USERNAME, NetworkConstants.BASIC_AUTH_PASSWORD);
    }

    private static <S> S createService(Class<S> serviceClass, String username, String password) {
        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            httpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "applicaton/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpBuilder.build();
        Retrofit retrofit = retrofitBuilder.client(client).build();
        return retrofit.create(serviceClass);


    }
}



