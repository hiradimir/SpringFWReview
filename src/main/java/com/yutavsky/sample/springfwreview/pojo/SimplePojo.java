package com.yutavsky.sample.springfwreview.pojo;

/**
 * Created by yutaka on 2015/01/31.
 */
public class SimplePojo implements Pojo{
    @Override
    public void foo() {
        this.bar();
    }

    @Override
    public void bar() {
        System.out.println("this.toString() = " + this.toString());
    }

    @Override
    public void poo() {
        throw new IllegalArgumentException("poo");
    }

}
