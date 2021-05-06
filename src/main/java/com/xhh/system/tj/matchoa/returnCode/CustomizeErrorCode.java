package com.xhh.system.tj.matchoa.returnCode;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    USER_NOT_FOUND(2001,"用户不存在"),
    USER_REPEAT(2002,"用户重复存在，请联系管理员"),
    USER_PASSWORD_ERROR(2003,"密码错误"),
    ;


    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public Integer getCode() { return code; }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code=code;
    }





}
