package com.hiradimir.sample.springfwreview.dao;

import lombok.Setter;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yutaka on 2015/03/13.
 */
public class CRUD {

    @Setter
    EntityManager manager;

    public <T> List<T> getAllEntlies(Class<T> clazz){
        final String className = clazz.getSimpleName();
        TypedQuery<T> tTypedQuery = manager.createQuery(String.format("from %s", className), clazz);
        
        return tTypedQuery.getResultList();
    }
    
    public <T> void create(T t){
        manager.persist(t);
    }

    public <T> T read(Class<T> clazz, Object indentify){
        return manager.find(clazz, indentify);
    }


    public <T> void update(T t){
        manager.merge(t);
    }
    
    
    public <T> void detele(T t){
        manager.remove(t);
    }

}
