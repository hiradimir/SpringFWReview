package com.hiradimir.sample.springfwreview.entity;

/**
 * Created by yutaka on 2015/03/13.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalData")
public class PersonalData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * id を取得する
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * id を設定する
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    @Column(length = 50, nullable = false)
    private String name;

    /**
     * name を取得する
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * name を設定する
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    @Column(length = 100)
    private String mail;

    /**
     * mail を取得する
     *
     * @return String
     */
    public String getMail() {
        return mail;
    }

    /**
     * mail を設定する
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    @Column
    private int age;

    /**
     * age を取得する
     *
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * age を設定する
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public PersonalData() {

    }

    public PersonalData(String name, String mail, int age) {
        this();
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                '}';
    }
}
