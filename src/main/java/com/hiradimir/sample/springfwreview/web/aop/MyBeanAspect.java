package com.hiradimir.sample.springfwreview.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by yutaka on 2015/02/27.
 */
@Aspect
@Component
public class MyBeanAspect {
    
    @Before("execution(* com.hiradimir.sample.springfwreview.web.IMyBean.addMessage(..))")
    public void addDataBefore(JoinPoint joinPoint){

        System.out.println("*addData before...*");
        
        StringBuilder args = new StringBuilder();

        for(Object ob : joinPoint.getArgs()){
            args.append(ob);
        }
        
        System.out.println(args);
        
    }
}
