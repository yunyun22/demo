package com.example.demo.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wang, jinqiao
 * @date 02/03/2021
 */
public class DateConvert implements Converter<String, Date> {

    private String pattern;


    public DateConvert(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        Date date=null;
        try {
            date= simpleDateFormat.parse(s);
            System.out.println("转换后的时间："+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
