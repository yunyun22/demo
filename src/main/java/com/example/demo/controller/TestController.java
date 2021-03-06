package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
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

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@RequestParam Date date) {
        System.out.println(date);
        return "hello world";
    }

    @RequestMapping(value = "/throwException", method = RequestMethod.GET)
    @ResponseBody
    public void throwException() {

        throw new BusinessException("404");

    }

}
