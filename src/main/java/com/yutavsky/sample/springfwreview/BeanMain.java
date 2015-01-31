package com.yutavsky.sample.springfwreview;

import com.yutavsky.sample.springfwreview.bean.Child;
import com.yutavsky.sample.springfwreview.bean.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yutaka on 2015/01/30.
 */
public class BeanMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Parent parent = (Parent) context.getBean("parent");

        System.out.println("parent.getName() = " + parent.getName());


        System.out.println("parent.getChild().getName() = " + parent.getChild().getName());
        
        Child child = (Child) context.getBean("child");

        System.out.println("child.getName() = " + child.getName());
        
    }
    
}
