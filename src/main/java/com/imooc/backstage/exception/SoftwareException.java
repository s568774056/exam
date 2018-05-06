package com.imooc.backstage.exception;

import com.imooc.backstage.enums.ResultEnum;

public class SoftwareException extends RuntimeException{

    private Integer code;

    public SoftwareException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
