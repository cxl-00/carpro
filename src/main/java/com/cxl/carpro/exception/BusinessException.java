package com.cxl.carpro.exception;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 11:48 上午
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 2528764459007664370L;

    private Integer code;
    private String msg;

    public BusinessException() {
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
