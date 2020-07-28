package com.tiandihui.vpn.common.api;

public enum ResultCode implements IErrorCode {

    SUCCESS(200,"success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "parameters is not correct "),
    UNAUTHORIZED(401, "No login yet or token has expired"),
    FORBIDDEN(403, "no permissions"),
    UNFINDUSER(1001, "Username does not exist"),
    WRONGCODE(1002, "Sorry,verification code is invalid or expired."),
    TIMEOUTCODE(1003, "Sorry,verification code is invalid or expired."),

    WRONGPASSWORD(1004, "password is not correct"),
    REPEATSENDCODE(1005, "We've sent a verification code to your email address"),
    RELOGINAGAIN(1006, "please login again，has expired"),
    UNFINDCOMMENT(1007, "找不到这条反馈问题的id"),
    SINGLESIGNOUT(1008, "you are already logged in on another device"),
    REPEATUSER(1009, "That  username is taken.Try another."),
    SENDCODESUCCESS(201, "\"We've sent a verification code to your email address"),
    ;



    private long code;
    private String message;
    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
