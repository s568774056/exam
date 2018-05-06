package com.imooc.backstage.handle;

import com.imooc.backstage.domain.Result;
import com.imooc.backstage.exception.SoftwareException;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //@ExceptionHandler value:需要捕获的异常类
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof SoftwareException) {
            SoftwareException girlException = (SoftwareException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
