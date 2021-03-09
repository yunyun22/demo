package com.example.demo.chain;

import java.lang.reflect.Method;

/**
 * @author wang, jinqiao
 * @date 09/03/2021
 */
public interface Process {

    /**
     * 责任链
     *
     * @param interceptorChain 链
     * @param proxy            代理对象
     * @param method           方法
     * @param args             参数
     * @return 返回值
     */
    Object process(InterceptorChain interceptorChain, Object proxy, Method method, Object[] args) throws Throwable;

}
