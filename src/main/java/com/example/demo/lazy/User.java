package com.example.demo.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wang, jinqiao
 * @title: USer
 * @date 10/03/2021
 */
@Service
public class User {

    @Autowired
    private Order order;
}
