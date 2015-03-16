package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class MessageHash extends BaseEntity{


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Hash hash;

    @ManyToOne
    private Message message;

}
