package com.example.demo.exception;

/**
 * @author wang, jinqiao
 * @date 03/03/2021
 */
public class BusinessException extends RuntimeException {

    private final String code;

    public BusinessException(String error,String code){
        super(error);
        this.code = code;
    }

    public BusinessException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
