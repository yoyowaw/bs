package com.youzhihua.bs.utils;

import com.youzhihua.bs.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @Author youzhihua
 * @Date 2019/5/13 22:28
 */
public final class ResultUtils {
    private static final Logger log = LoggerFactory.getLogger(ResultUtils.class);

    public ResultUtils() {
    }

    public static Result success() {
        return success((Object)null);
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result error(String errorCode, String errorMsg) {
        return error(errorCode, errorMsg, (Object)null);
    }

    public static Result error(BaseException exception) {
        if (exception == null) {
            throw new IllegalArgumentException("exception is null");
        } else {
            return error(exception.getErrCode(), exception.getErrMessage());
        }
    }

    public static <T> Result<T> error(String errorCode, String errorMsg, T data) {
        Result result = new Result();
        result.setSuccess(false);
        result.setErrCode(errorCode);
        result.setErrMsg(errorMsg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(Throwable throwable, String path, String errorCode, String errorMsg, T data) {
        Result result = new Result();
        result.setSuccess(false);
        result.setThrowable(throwable);
        result.setPath(path);
        result.setErrCode(errorCode);
        result.setErrMsg(errorMsg);
        result.setData(data);
        return result;
    }


}
