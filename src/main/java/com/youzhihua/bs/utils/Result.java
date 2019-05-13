package com.youzhihua.bs.utils;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author youzhihua
 * @Date 2019/5/13 22:28
 */
public class Result<T> {
    private boolean success;
    private T data;
    private String errCode;
    private String errMsg;
    private String path;
    private Throwable throwable;

    public Result() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @ApiIgnore
    public String getPath() {
        return this.path;
    }

    @ApiIgnore
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
