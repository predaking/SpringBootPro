package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return this.code == 0;
    }

    public Result() {

    }

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("ok");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode(0);
        result.setMsg("ok");
        return result;
    }

    public static <T> Result<T> success(T data, String msg) {
        Result<T> result = new Result<>(data);
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
