package com.example.demo.config;

import com.example.demo.convert.DateConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang, jinqiao
 */
@Configuration
public class ConvertConfig {

    public static final String PATTERN = "yyyy-MM-dd";

    @Bean
    public DateConvert dateConvert(){
        return new DateConvert(PATTERN);
    }

}
