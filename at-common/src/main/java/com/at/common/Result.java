package com.at.common;

import lombok.Data;

@Data
public class Result<T> {
    // 是否成功
    private Boolean success;
    // 错误信息
    private String msg;
    // 错误码
    private String code;
    private T data;

    private Result() {

    }

    private Result(Boolean success, String msg, String code, T data) {
        this.data = data;
        this.msg = msg;
        this.success = success;
        this.code = code;
    }

    public static <T> Result<T> withSuccess(T data) {
        return new Result<>(true, "", "", data);
    }

    public static <T> Result<T> withError(String code, String msg) {
        return new Result<>(false, code, msg, null);
    }
}
