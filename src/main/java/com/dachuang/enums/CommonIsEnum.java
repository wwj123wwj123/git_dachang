package com.dachuang.enums;

/**
 * 是否通用枚举
 *
 * @author AJAXXJ
 * @date 10:54 2022/8/19
 */
public enum CommonIsEnum {
    IS(1, "是"), NO(0, "不是");

    private Integer code;

    private String msg;

    CommonIsEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
