package com.example.demo;

import com.example.demo.domain.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang, jinqiao
 */
public class Example03 {


    @Test
    public void testMetaObject(){

        User user = new User();
        user.setName("w");
        user.setAge(1);
        Map<String,Object> map = new HashMap<>();

        map.put("user",user);
        map.put("test","test");
        MetaObject metaObject = SystemMetaObject.forObject(map);
        System.out.println(metaObject.getValue("user.name"));
        System.out.println(metaObject.getValue("test"));
    }

}
