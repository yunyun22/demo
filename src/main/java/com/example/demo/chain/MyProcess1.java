package com.example.demo.chain;

import java.lang.reflect.Method;

/**
 * @author wang, jinqiao
 * @date 09/03/2021
 */
public class MyProcess1 implements Process {
    @Override
    public Object process(InterceptorChain interceptorChain, Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------MyProcess1 start");
        Object process = interceptorChain.process(interceptorChain, proxy, method, args);
        System.out.println("-----------MyProcess1 end");

        return process;
    }
}
