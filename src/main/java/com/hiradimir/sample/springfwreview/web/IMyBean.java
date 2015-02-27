package com.hiradimir.sample.springfwreview.web;

import java.util.List;

/**
 * Created by yutaka on 2015/02/27.
 */
public interface IMyBean {
    List<String> getMessages();

    String getMessages(int n);

    void setMessage(int n, String message);

    void addMessage(String message);

    void setMessages(List<String> messages);
}
