package com.imooc.backstage.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    INSERT_NODATA(300, "插入数据失败"),
    DELETE_NODATA(400, "数据可能已不存在"),
    UPDATE_NODATA(500, "更新数据失败"),
    ;
	
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
