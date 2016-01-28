package com.example.koombea.mvpdemo.model.error;

/**
 * Created by koombea on 28/01/16.
 */
public class ApiError {
    private String code;
    private String error;

    public ApiError(){
        code = "500";
        error="unknow server error";

    }

    public String getError() {
        return error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setError(String error) {
        this.error = error;
    }

}
