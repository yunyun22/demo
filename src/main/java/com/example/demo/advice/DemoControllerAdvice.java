package com.example.demo.advice;

import com.example.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wang, jinqiao
 * @date 03/03/2021
 */
@ControllerAdvice("com.example.demo")
public class DemoControllerAdvice {

    @ExceptionHandler({BusinessException.class})
    public String handlerBusinessException(BusinessException exception, HttpServletRequest request,
                                           HttpServletResponse response) {
        exception.printStackTrace();
        String uri = request.getRequestURI();
        System.out.println("uri===:" + uri);
        StringBuffer url = request.getRequestURL();
        System.out.println("url===:" + url);
        return "error";
    }

}
