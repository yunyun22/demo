package com.example.demo;

import com.example.demo.domain.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.jupiter.api.Test;

/**
 * @author wang, jinqiao
 */
public class Example03 {


    @Test
    public void testMetaObject(){

        User user = new User();
        user.setName("w");
        user.setAge(1);

        MetaObject metaObject = SystemMetaObject.forObject(user);
        Object name = metaObject.getValue("name");

        System.out.println(name);
    }

}
