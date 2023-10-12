package com.course.project.macrunyi_xiaoran_xue.cfg;

public enum CfgEnum {

    USER_REGISTER("user_register_queue", "exchange_test", "user_register_routing"),
    ;

    public String QUEUE_NAME;
    public String EXCHANGE_NAME;
    public String ROUTING_NAME;

    CfgEnum(String QUEUE_NAME, String EXCHANGE_NAME, String ROUTING_NAME) {
        this.QUEUE_NAME = QUEUE_NAME;
        this.EXCHANGE_NAME = EXCHANGE_NAME;
        this.ROUTING_NAME = ROUTING_NAME;
    }

    public String getQUEUE_NAME() {
        return QUEUE_NAME;
    }

    public String getEXCHANGE_NAME() {
        return EXCHANGE_NAME;
    }

    public String getROUTING_NAME() {
        return ROUTING_NAME;
    }
}
