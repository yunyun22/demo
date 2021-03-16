package com.example.demo.chain;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wang, jinqiao
 * @date 09/03/2021
 */
@Intercepts(
        value = {
                @Signature(
                        type = Executor.class,
                        method = "query",
                        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
                )
        })
public class InterceptorChainAdapter implements Interceptor {


    private Object proxy;

    private Object target;

    private final List<Process> processes = new ArrayList<>();

    public InterceptorChainAdapter() {
        super();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        InterceptorChain interceptorChain = new InterceptorChain(target, proxy, processes);
        return interceptorChain.process(interceptorChain, proxy, invocation.getMethod(), invocation.getArgs());
    }

    @Override
    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
        //如果被代理
        if (target != wrap) {
            this.target = target;
            this.proxy = wrap;
        }
        return wrap;

    }

    @Override
    public void setProperties(Properties properties) {
        processes.add(new MyProcess1());
        processes.add(new MyProcess2());
    }
}
