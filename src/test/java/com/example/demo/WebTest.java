package com.example.demo;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wang, jinqiao
 * @date 23/03/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class WebTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserMapper(){
        User entity = new User();
        entity.setPhone("18700001111");
        userService.getUserByEntity(entity);
    }
}
