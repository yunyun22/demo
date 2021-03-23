package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author wang, jinqiao
 */
@Controller
@RequestMapping("/test")
public class TestController {


//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        //将yyyy-mm-dd类型转换为date类型
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        //日期自动计算关掉！
//        dateFormat.setLenient(false);
//        //自定义转换方法！
//        binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
//    }


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        User user = new User();
        user.setPhone("18700001111");
        return userService.getUserByEntity(user).toString();
    }

    @RequestMapping(value = "/throwException", method = RequestMethod.GET)
    @ResponseBody
    public void throwException() {

        throw new BusinessException("404");

    }

}
