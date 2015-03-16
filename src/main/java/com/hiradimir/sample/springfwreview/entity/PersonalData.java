package com.hiradimir.sample.springfwreview.entity;

/**
 * Created by yutaka on 2015/03/13.
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalData")
@Data
public class PersonalData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(length = 50, nullable = false)
    private String name;


    @Column(length = 100)
    private String mail;


    @Column
    private int age;


    public PersonalData() {

    }

    public PersonalData(String name, String mail, int age) {
        this();
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

}
