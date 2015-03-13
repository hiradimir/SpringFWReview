package com.hiradimir.sample.springfwreview.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;

/**
 * Created by yutaka on 2015/03/13.
 */
public class App {
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        final LocalContainerEntityManagerFactoryBean factory = context.getBean(LocalContainerEntityManagerFactoryBean.class);
        
        
        final EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
        
        final PersonalData data = manager.find(PersonalData.class, 1L);

        System.out.println(data);
    }
}
