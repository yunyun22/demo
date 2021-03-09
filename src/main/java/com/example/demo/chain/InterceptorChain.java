package com.example.demo.chain;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang, jinqiao
 * @date 09/03/2021
 */
public class InterceptorChain implements Process, InvocationHandler {


    private Object target;

    private final List<Process> processes = new ArrayList<>();


    public InterceptorChain() {
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public InterceptorChain(Object target) {
        this.target = target;
    }

    int i = 0;

    @Override
    public Object process(InterceptorChain interceptorChain, Object proxy, Method method, Object[] args) throws Throwable {


        if (i == processes.size()) {
            return method.invoke(target, args);
        }

        return processes.get(i++).process(interceptorChain, proxy, method, args);
    }


    public void addProcess(Process process) {
        processes.add(process);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return process(this, proxy, method, args);
    }
}
