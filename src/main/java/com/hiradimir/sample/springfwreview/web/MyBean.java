package com.hiradimir.sample.springfwreview.web;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutaka on 2015/02/27.
 */
@Component
public class MyBean implements IMyBean {
    @Override
    public List<String> getMessages() {
        return messages;
    }
    @Override
    public String getMessages(int n) {
        return this.messages.get(n);
    }

    @Override
    public void setMessage(int n, String message){
        this.messages.add(n, message);
    }
    @Override
    public void addMessage(String message){
        this.messages.add(message);
    }

    public MyBean(){
        messages.add("This is Bean Sample! @ constructor");
    }

    @Override
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    private List<String> messages = new ArrayList<>();


    @Override
    public String toString() {

        return "MyBean{" +
                "messages=" + StringUtils.collectionToCommaDelimitedString(this.messages) +
                '}';
    }
}
