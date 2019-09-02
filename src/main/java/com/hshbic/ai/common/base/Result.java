package com.hshbic.ai.common.base;

import java.util.StringTokenizer;

public class Result {
    public static final String successCode = "200";
    public static final String errorCode = "500";
    public static final String errorCode400 = "400";
    private String code;
    private String message;

    public Result(){}
    public Result(String code, String message){
        this.code = code;
        this.message = message;
    }


    /** 成功返回200 */
    public static Result success() {
        Result r = new Result();
        r.setCode(successCode);
        r.setMessage("操作成功");
        return r;
    }

    /** 系统异常，code=500 */
    public static Result fail() {
        Result r = new Result();
        r.setCode(errorCode);
        r.setMessage("系统异常");
        return r;
    }

    /** 系统异常，code=400 */
    public static Result fail400() {
        Result r = new Result();
        r.setCode(errorCode400);
        r.setMessage("参数错误");
        return r;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
