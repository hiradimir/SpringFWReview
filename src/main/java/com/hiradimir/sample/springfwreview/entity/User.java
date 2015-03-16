package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString(callSuper = true)
public class User extends BaseEntity{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column
    private String userName;

}
