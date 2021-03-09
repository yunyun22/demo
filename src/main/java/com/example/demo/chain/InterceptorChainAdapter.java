package com.example.demo.chain;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

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
public class InterceptorChainAdapter extends InterceptorChain implements Interceptor {

    public InterceptorChainAdapter() {
        super();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return process(this, this, invocation.getMethod(), invocation.getArgs());
    }

    @Override
    public Object plugin(Object target) {
        setTarget(target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

        this.addProcess(new MyProcess1());
        this.addProcess(new MyProcess2());
    }
}
