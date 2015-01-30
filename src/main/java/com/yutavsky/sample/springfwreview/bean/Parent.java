package com.yutavsky.sample.springfwreview.bean;

/**
 * Created by yutaka on 2015/01/30.
 */
public class Parent {
    private String name;

    /**
     * name を取得する
     *
     * @return  String
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


    private Child child;

    /**
     * child を取得する
     *
     * @return Child
     */
    public Child getChild() {
        return child;
    }

    /**
     * child を設定する
     *
     * @param child
     */
    public void setChild(Child child) {
        this.child = child;
    }


}
