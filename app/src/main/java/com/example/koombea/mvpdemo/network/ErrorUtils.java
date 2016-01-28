package com.example.koombea.mvpdemo.network;

import com.example.koombea.mvpdemo.model.error.ApiError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by koombea on 28/01/16.
 */
public class ErrorUtils {
    public static ApiError parseError(Response<?> response){
        Converter<ResponseBody, ApiError> converter =
                ServiceGenerator.getRetrofitBuilder().build()
                        .responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError();
        }

        return error;

    }
}
