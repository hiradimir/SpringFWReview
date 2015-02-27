package com.yutavsky.sample.springfwreview;

import com.yutavsky.sample.springfwreview.pojo.Pojo;
import com.yutavsky.sample.springfwreview.pojo.SimplePojo;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by yutaka on 2015/01/31.
 */
public class AOPMain {

    static public class HijackBeforeMethod implements MethodBeforeAdvice
    {
        @Override
        public void before(Method method, Object[] args, Object target)
                throws Throwable {
            System.out.println("HijackBeforeMethod : Before method hijacked!");
        }
    }

    static public class HijackAfterMethod implements AfterReturningAdvice
    {
        @Override
        public void afterReturning(Object returnValue, Method method,
                                   Object[] args, Object target) throws Throwable {
            System.out.println("HijackAfterMethod : After method hijacked!");
        }
    }

    static public class HijackThrowException implements ThrowsAdvice {
        public void afterThrowing(Exception e) {
            System.out.println("HijackThrowException : Throw exception hijacked!");
        }
    }
    
    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new HijackBeforeMethod());
        factory.addAdvice(new HijackAfterMethod());
        factory.setExposeProxy(true);
//        factory.addAdvice(new HijackThrowException());
        
        
        Pojo pojo = (Pojo)factory.getProxy();

        pojo.foo();
        pojo.bar();
//        pojo.poo();
        pojo.bar();
    }
}
