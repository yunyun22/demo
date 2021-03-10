package com.example.demo.config;

import com.example.demo.lazy.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author wang, jinqiao
 * @title: ServiceConfig
 * @date 10/03/2021
 */
@Configuration
public class ServiceConfig {

    @Bean()
    @Lazy
    public Order getOrder(){
        return  new Order();
    }
}
