package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yutaka on 2015/03/13.
 */
@Entity
@AttributeOverrides({@AttributeOverride(name="created", column=@Column(name="created"))})
@Data
@ToString(callSuper = true)
public class Hash extends BaseEntity {

    @Column
    private String hash;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "MessageHash", 
            joinColumns = {@JoinColumn(name = "hash_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "message_id")})
    private List<Message> messageList = new LinkedList<>();
}
