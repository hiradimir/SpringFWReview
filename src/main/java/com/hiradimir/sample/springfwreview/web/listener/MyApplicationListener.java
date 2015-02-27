package com.hiradimir.sample.springfwreview.web.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.EventListener;

/**
 * Created by yutaka on 2015/02/27.
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("refreshed!");
        
    }
}
