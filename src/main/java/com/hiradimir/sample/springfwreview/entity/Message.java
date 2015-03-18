package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yutaka on 2015/03/13.
 */
@Entity
@Data
@ToString(callSuper = true)
public class Message extends BaseEntity{

    
    @Column(length = 255)
    private String text;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    
}
