package com.hiradimir.sample.springfwreview.entity;

import com.hiradimir.sample.springfwreview.dao.CRUD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by yutaka on 2015/03/13.
 */
public class App3 {
    
    
    static void log(final Object... args){
        final StringBuilder sb = new StringBuilder();
        String delimiter  = "";
        for(Object arg : args){
            sb.append(delimiter);
            if(arg != null){
                sb.append(arg.toString());
            }else{
                sb.append("null");
            }
            delimiter = ",";
        }
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        final LocalContainerEntityManagerFactoryBean factory = context.getBean(LocalContainerEntityManagerFactoryBean.class);
        final EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();

        final PersonalData data = manager.find(PersonalData.class, 1L);

        System.out.println(data);
        
        CRUD crud = new CRUD();
        
        crud.setManager(manager);

        EntityTransaction entityTransaction = manager.getTransaction();
        entityTransaction.begin();


        User newUser = new User();
        newUser.setUserName("takaishi");
        
        Message message = new Message();
        message.setText("hoge");
        message.setUser(newUser);
        log("create Message" , message);
        crud.create(message);
        log("created Message" , message);
        
        entityTransaction.commit();
        
        log("end");
        
    }
}
