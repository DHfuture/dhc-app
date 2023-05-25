package com.dhc.app.api.service.administrator.constants;

/**
 * @Author donghongchen
 * @create 2023/5/24 14:04
 * @Description:
 */
public enum AdministratorRole {

    /**
     * 超级管理员
     */
    ROOT(0),

    /**
     * 管理员
     */
    ADMIN(2),

    /**
     * 普通用户
     */
    USER(1),

    ;

    public static final String DOC = "1超级管理员;2管理员;3普通用户;";

    private final Integer value;


    AdministratorRole(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
