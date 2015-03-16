package com.hiradimir.sample.springfwreview.entity;

import com.hiradimir.sample.springfwreview.dao.CRUD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by yutaka on 2015/03/13.
 */
public class App {
    
    
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

        log("newUser", newUser);
        crud.create(newUser);

        User fetchedUser = crud.read(User.class, newUser.getId());
        log("fetchedUser", fetchedUser);


        fetchedUser.setUserName("hirayama");
        crud.update(fetchedUser);

        User reFetchedUser = crud.read(User.class, newUser.getId());
        log("reFetchedUser", reFetchedUser);
        
        crud.detele(reFetchedUser);

        User reReFetchedUser = crud.read(User.class, newUser.getId());
        log("reReFetchedUser", reReFetchedUser);


        // ここの挙動がわかんねい
        log("newUser", newUser);
        crud.create(newUser);
        log("newUser", newUser);
        
        
        Message newMessage = new Message();
        newMessage.setText("ほげ");
        newMessage.setUser(newUser);
        
        crud.create(newMessage);

        
        Hash newHash = new Hash();
        newHash.setHash("hoge");
        crud.create(newHash);

        {
            Message fetchedMessage = crud.read(Message.class, newMessage.getId());
            log("fetchedMessage", fetchedMessage);
            newHash.getMessageList().add(fetchedMessage);
        }
        
        crud.update(newHash);

        {
            Hash fetchedHash = crud.read(Hash.class, newHash.getId());
            log("fetchedHash", fetchedHash);
        }

        {
            // うまくいかない
            Message _fetchedMessage = crud.read(Message.class, newMessage.getId());
            log("fetchedMessage", _fetchedMessage);
        }
        // 無意味
//        entityTransaction.commit();
//        
//        entityTransaction.begin();

//        だめ
        
//        manager.flush();

        Message newMessageForHash = new Message();
        newMessageForHash.setText("ふが");
        newMessageForHash.setUser(newUser);
        crud.create(newMessageForHash);
        
        MessageHash messageHash = new MessageHash();
        messageHash.setHash(newHash);
        messageHash.setMessage(newMessageForHash);
        
        crud.create(messageHash);
        
        log("messageHash", messageHash);

        {
            Hash fetchedHash = crud.read(Hash.class, newHash.getId());
            log("fetchedHash", fetchedHash);
        }
        
        
        
//        log("hashs", crud.getAllEntlies(Hash.class));
//        log("messages", crud.getAllEntlies(Message.class));
        
        
//        MessageHashMap messageHashMap = new MessageHashMap();
//        messageHashMap.setMessage(newMessage);
//        messageHashMap.setHash(newHash);
//        
//        crud.create(messageHashMap);
//
//
//        MessageHash fetchedMessageHashMap = crud.read(MessageHash.class);
//        log("fetchedMessageHashMap", fetchedMessageHashMap);
//
//



        entityTransaction.commit();
        
        
        
        
        
    }
}
