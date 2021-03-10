package com.example.demo.lazy;

/**
 * @author wang, jinqiao
 * @date 10/03/2021
 */
public interface ObjectFactory<T> {

    /**
     * 获取对象
     *
     * @return 代理后的对象
     */
    T get();
}
