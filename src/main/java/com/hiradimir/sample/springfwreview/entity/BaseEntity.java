package com.hiradimir.sample.springfwreview.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by yutaka on 2015/03/13.
 */
@ToString(callSuper = false)
public class BaseEntity {

    @Setter
    @Column
    private Date created;
    
//    @Getter
//    @Setter
//    @Column
//    private Date updated;


    public Date getCreated() {
        return new Date();
    }
}
