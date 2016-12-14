package com.mickeyfr33.course;

import com.mickeyfr33.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by michaelsmith on 12/14/16.
 * Copyright Acceptto Corporation.
 */

@Entity
public class Course extends BaseEntity {

    private String title;
    private String url;

    protected Course(){
        super();
    }

    public Course(String title, String url) {
        //calls the constructor above and initializes the ID field as null, which is later auto generated.
        this();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
