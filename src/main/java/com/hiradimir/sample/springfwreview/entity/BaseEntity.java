package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by yutaka on 2015/03/13.
 */
@MappedSuperclass
@Data
@ToString(callSuper = false)
public abstract class BaseEntity {
    
    @Column
    private Date created = new Date();

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    @Version
    @Column
    private Date version;
}
