package com.course.project.macrunyi_xiaoran_xue.web.resp;

public enum RESPENUM {
    SUCCESS(200, "success"),

    PARAM_ERR(403, "param err"),

    INTERNAL_ERR(500, "internal err"),
    ;
    private Integer code;
    private String desc;

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
