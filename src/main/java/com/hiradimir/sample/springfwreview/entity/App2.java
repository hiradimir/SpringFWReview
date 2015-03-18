package com.hiradimir.sample.springfwreview.entity;

import com.hiradimir.sample.springfwreview.dao.CRUD;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by yutaka on 2015/03/13.
 */
public class App2 {
    
    
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


        Date d = new Date();
        Date d50 = null;
        for(int i = 0; i < 100; i++){

            Message message = new Message();
            message.setText("hoge" + i);
            Date created = new Date();
            created.setTime(d.getTime() + (long)(60 * 1000 * i));
            message.setCreated(created);
            log("create Message" , message);
            crud.create(message);
            if(i == 50){
                d50 = created;
            }
        }
//        Session session = manager.unwrap(org.hibernate.Session.class);
//        Filter filter = session.enableFilter("messageHistory");
//        filter.setParameter("maxCreated", d50);
//        Query query = session.createQuery("from Message");
        
        String queryString = "Select m from Message m WHERE created < :maxCreated ORDER BY id";
        TypedQuery<Message> query = manager.createQuery(queryString, Message.class);
        query.setParameter("maxCreated", d50);
        
        
        List<Message> list = query.getResultList();


        log("created < ", d50);

        for (Message aList : list) {
            log("message", aList);
        }
        
        

        entityTransaction.commit();
        
        
        
        
        
    }
}
