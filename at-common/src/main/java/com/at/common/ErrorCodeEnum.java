package com.at.common;

public enum ErrorCodeEnum {

    /**
     *
     */
    SYS_ERROR("sys.error", "sys.error");

    private String msg;
    private String code;

    ErrorCodeEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
