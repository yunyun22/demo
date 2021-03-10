package com.example.demo.lazy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wang, jinqiao
 * @title: ObjectFactoryImpl
 * @date 10/03/2021
 */
public class ObjectFactoryImpl<T> implements ObjectFactory<T> {

    private T object;


    public ObjectFactoryImpl(T object) {
        this.object = object;
    }

    @Override
    public T get() {
        return object;
    }


    @SuppressWarnings("uncheck")
    public ObjectFactory<T> of(Class<T> tClass){
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(tClass);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());
        object = (T) enhancer.create();
        return new ObjectFactoryImpl<>(object);

    }


    static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {


            String name = method.getName();

            if (name.contains("Get")){
                //obj.getClass().getMethod("",)
            }

            Object object = proxy.invokeSuper(obj, args);
            return object;
        }
    }
}
