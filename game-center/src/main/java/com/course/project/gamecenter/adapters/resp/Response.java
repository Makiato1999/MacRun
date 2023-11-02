package com.course.project.gamecenter.adapters.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 9191113464599235349L;
    private int code;
    private String msg;
    private T data;

    public Response() {

    }

    public Response(RESPENUM code, T data) {
        this.code = code.getCode();
        this.msg = code.getDesc();
        this.data = data;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public void setResponseCode(RESPENUM code) {
        this.code = code.getCode();
        this.msg = code.getDesc();
    }

    public static <T> Response<T> success(T data) {
        return success(data, "");
    }

    public static <T> Response<T> success(String msg) {
        return success(null, msg);
    }

    public static <T> Response<T> success(T data, String msg) {
        return new Response<>(RESPENUM.SUCCESS.getCode(), msg, data);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>(RESPENUM.INTERNAL_ERR.getCode(), message, null);
    }
}
