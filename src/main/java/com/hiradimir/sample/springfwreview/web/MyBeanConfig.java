package com.hiradimir.sample.springfwreview.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yutaka on 2015/02/27.
 */
@Configuration
@ComponentScan
public class MyBeanConfig {
    
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
