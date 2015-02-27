package com.hiradimir.sample.springfwreview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yutaka on 2015/02/27.
 */
@Component
public class MyBean2 {
    
    @Autowired
    private IMyBean myBean;
    
    private Date date = Calendar.getInstance().getTime();

    public IMyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(IMyBean myBean) {
        this.myBean = myBean;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {

        return String.format("MyBean2(%s)[%s]", this.date, this.myBean);
    }
}
