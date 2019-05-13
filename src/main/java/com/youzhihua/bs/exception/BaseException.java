package com.youzhihua.bs.exception;

/**
 * @Author youzhihua
 * @Date 2019/5/13 22:29
 */
public class BaseException  extends RuntimeException {
    private String path;
    private String errCode;
    private String errMessage;

    public BaseException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public BaseException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BaseException(String errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BaseException(Throwable cause, String path, String errCode, String errMessage) {
        super(errMessage, cause);
        this.path = path;
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getPath() {
        return this.path;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseException)) {
            return false;
        } else {
            BaseException other = (BaseException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$path = this.getPath();
                    Object other$path = other.getPath();
                    if (this$path == null) {
                        if (other$path == null) {
                            break label47;
                        }
                    } else if (this$path.equals(other$path)) {
                        break label47;
                    }

                    return false;
                }

                Object this$errCode = this.getErrCode();
                Object other$errCode = other.getErrCode();
                if (this$errCode == null) {
                    if (other$errCode != null) {
                        return false;
                    }
                } else if (!this$errCode.equals(other$errCode)) {
                    return false;
                }

                Object this$errMessage = this.getErrMessage();
                Object other$errMessage = other.getErrMessage();
                if (this$errMessage == null) {
                    if (other$errMessage != null) {
                        return false;
                    }
                } else if (!this$errMessage.equals(other$errMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseException;
    }



    public String toString() {
        return "BaseException(path=" + this.getPath() + ", errCode=" + this.getErrCode() + ", errMessage=" + this.getErrMessage() + ")";
    }
}
