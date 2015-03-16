package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    private String text;

    @OneToOne
    private User user;

//    @OneToMany(mappedBy = "hash")
//    private List<MessageHashMap> messageHashMapList = new LinkedList<>();
    
    @ManyToMany
    @JoinTable(name = "MessageHash",
            joinColumns = {@JoinColumn(name = "message_id")},
            inverseJoinColumns = {@JoinColumn(name = "hash_id")})
    private List<Hash> hashList = new LinkedList<>();
}
