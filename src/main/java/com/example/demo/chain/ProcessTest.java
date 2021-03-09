package com.example.demo.chain;

import java.lang.reflect.Proxy;

/**
 * @author wang, jinqiao
 * @date 09/03/2021
 */
public class ProcessTest {


    public static void main(String[] args) {

        SayHello sayHello = new SayHello();

        InterceptorChain interceptorChain = new InterceptorChain(sayHello);
        interceptorChain.addProcess(new MyProcess1());
        interceptorChain.addProcess(new MyProcess2());

        Say say = (Say) Proxy.newProxyInstance(ProcessTest.class.getClassLoader(), new Class[]{Say.class}, interceptorChain);
        say.say();

    }


    static class SayHello implements Say {

        @Override
        public void say() {
            System.out.println("hello");
        }
    }

}
