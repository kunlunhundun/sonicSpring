package com.tiandihui.vpn.common.api;

public enum ResultCode implements IErrorCode {

    SUCCESS(200,"操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNFINDUSER(1001, "找不到用户名"),
    WRONGCODE(1002, "验证码不正确"),
    TIMEOUTCODE(1003, "验证码超时，请重新发送"),

    WRONGPASSWORD(1004, "密码不正确"),
    REPEATSENDCODE(1005, "验证码已经发送过，90S 后才能重新发送"),
    RELOGINAGAIN(1006, "请重新登录，登录已经失效"),
    UNFINDCOMMENT(1007, "找不到这条反馈问题的id"),
    SINGLESIGNOUT(1008, "你已经在其他设备登录了"),
    REPEATUSER(1009, "用户名已经注册过"),
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
