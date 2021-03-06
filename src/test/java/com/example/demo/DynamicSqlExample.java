package com.example.demo;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.DbUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DynamicSqlExample {

    @BeforeEach
    public void initData() {
        DbUtils.initData();
    }

    @Test
    public void testDynamicSql() throws IOException {
        // 获取配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 通过SqlSessionFactoryBuilder的build()方法创建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 调用openSession()方法创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User entity = new User();
        entity.setPhone("18700001111");
        List<User> userList =  userMapper.getUserByEntity(entity);
        System.out.println(userList);
        //System.out.println(JSON.toJSONString(userList));
    }

}
