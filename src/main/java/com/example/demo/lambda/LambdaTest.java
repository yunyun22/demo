package com.example.demo.lambda;

import com.example.demo.entity.User;

import java.util.function.Function;

/**
 * @author wang, jinqiao
 * @title: LambdaTest
 * @date 22/03/2021
 */
public class LambdaTest {
    public static void main(String[] args) {

        Function<User, Long> getId = User::getId;
        Function<User, Long> getId1 = User::getId;

        System.out.println(getId.getClass());
        System.out.println(getId1.getClass());
    }
}
