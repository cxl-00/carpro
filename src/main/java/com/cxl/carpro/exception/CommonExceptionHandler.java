package com.cxl.carpro.exception;


import com.cxl.carpro.comom.RestBaseResponse;
import com.cxl.carpro.comom.ResultCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author Chenxiaoling
 * @date 2020/9/19 12:57 下午
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        e.printStackTrace();
        return RestBaseResponse.failure(ResultCode.BAD_SERVICE_CODE,"bad service");
    }

    @ExceptionHandler(BusinessException.class)
    public Object businessExceptionHandler(BusinessException e) {
        e.printStackTrace();
        return RestBaseResponse.failure(e.getCode(),e.getMsg());
    }

}
