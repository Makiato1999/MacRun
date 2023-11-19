package com.course.project.heartratemonitor.web.resp;

public enum RESPENUM {
    SUCCESS(200, "success"),

    PARAM_ERR(403, "param err"),

    INTERNAL_ERR(500, "internal err"),
    ;
    private final Integer code;
    private final String desc;

    RESPENUM(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
