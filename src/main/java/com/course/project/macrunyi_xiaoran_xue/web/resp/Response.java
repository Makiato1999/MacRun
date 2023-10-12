package com.course.project.macrunyi_xiaoran_xue.web.resp;

import java.io.Serializable;
import java.util.Map;

public class Response<T> implements Serializable {
    private boolean success;
    private T data;
    private String code;
    private String msg;

    public Response(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {
    }

    public Response(boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public Response success(T data) {
        return new Response(Boolean.TRUE, RESPENUM.SUCCESS.getCode().toString(), RESPENUM.SUCCESS.getDesc(), data);
    }

    public Response serverFail() {
        return new Response(Boolean.FALSE, RESPENUM.INTERNAL_ERR.getCode().toString(),
                RESPENUM.INTERNAL_ERR.getDesc(), null);
    }

    public static Response fail(RESPENUM respenum) {
        return new Response(Boolean.FALSE, respenum.getCode().toString(), respenum.getDesc(), null);
    }
}
