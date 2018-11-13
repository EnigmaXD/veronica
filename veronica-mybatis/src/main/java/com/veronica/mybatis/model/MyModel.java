package com.veronica.mybatis.model;

import org.springframework.stereotype.Component;

import com.veronica.mybatis.annotation.From;

@Component
@From("t_shop")
public class MyModel {

    private String id;

    private String linkmanTel;

    public String getLinkmanTel() {
        return linkmanTel;
    }

    public void setLinkmanTel(String linkmanTel) {
        this.linkmanTel = linkmanTel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
