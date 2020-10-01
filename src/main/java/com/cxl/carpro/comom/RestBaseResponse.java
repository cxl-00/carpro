package com.cxl.carpro.comom;

/**
 * @author Chenxiaoling
 * @date 2020/10/1 12:53 下午
 */
public class RestBaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    private RestBaseResponse() {
    }

    private RestBaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private RestBaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RestBaseResponse<T> success(T data) {
        return success().data(data);
    }

    public static RestBaseResponse.Builder success() {
        return new RestBaseResponse.DefaultBuilder(0, "success");
    }

    public static <T> RestBaseResponse<T> failure(Integer code, String msg) {
        return (new RestBaseResponse.DefaultBuilder(code, msg)).build();
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

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestBaseResponse{code=" + this.code + ", msg='" + this.msg + "'}";
    }

    public static class DefaultBuilder implements RestBaseResponse.Builder {
        private Integer code;
        private String msg;

        public DefaultBuilder(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public <T> RestBaseResponse<T> build() {
            return new RestBaseResponse(this.code, this.msg);
        }

        @Override
        public <T> RestBaseResponse<T> data(T data) {
            return new RestBaseResponse(this.code, this.msg, data);
        }
    }

    public interface Builder {
        <T> RestBaseResponse<T> build();

        <T> RestBaseResponse<T> data(T var1);
    }
}
