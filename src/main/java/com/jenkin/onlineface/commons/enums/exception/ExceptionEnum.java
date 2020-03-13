package com.jenkin.onlineface.commons.enums.exception;

public enum ExceptionEnum {


    ERROR_PARAM_EXCEPTION("400","参数错误"),
    ERROR_EXCEPTION("500","系统错误");

    ExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

//    public void setCode(String code) {
//        this.code = code;
//    }

    public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }


}
