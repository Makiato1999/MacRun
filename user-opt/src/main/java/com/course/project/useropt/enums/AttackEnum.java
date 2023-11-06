package com.course.project.useropt.enums;

public enum AttackEnum {
    DO_NOT_ATTACK(0, "DO_NOT_ATTACK"),

    SHELTERING(1, "SHELTERING"),

    ESCAPING(2, "ESCAPING"),

    FIGHTING_BACK(3, "FIGHTING_BACK"),
    ;

    private Integer id;
    private String desc;

    AttackEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static AttackEnum getEnumById(Integer id) {
        for (AttackEnum attachEnum : AttackEnum.values()) {
            if (attachEnum.id.equals(id)) {
                return attachEnum;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
