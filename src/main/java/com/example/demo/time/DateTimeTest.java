package com.example.demo.time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wang, jinqiao
 * @title: DateTimeTest
 * @date 11/03/2021
 */
public class DateTimeTest {

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) - 14);
        Date time = now.getTime();
        System.out.println(time);

    }
}
