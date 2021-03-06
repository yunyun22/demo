package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jinqwang
 */
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return list
     */
    List<User> listAllUser();

    /**
     * 使用id查询
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Select("select * from user where id=#{userId,jdbcType=INTEGER}")
    User getUserById(@Param("userId") String userId);

    /**
     * 用户列表
     *
     * @param user 用户
     * @return 用户列表
     */
    List<User> getUserByEntity(User user);

    /**
     * 使用电话号码查询
     *
     * @param phone 电话号码
     * @return 用户
     */
    User getUserByPhone(@Param("phone") String phone);

}