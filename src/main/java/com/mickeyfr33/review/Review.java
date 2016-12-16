package com.mickeyfr33.review;

import com.mickeyfr33.core.BaseEntity;
import com.mickeyfr33.course.Course;
import com.mickeyfr33.user.User;

import javax.persistence.*;

/**
 * Created by michaelsmith on 12/14/16.
 * Copyright Acceptto Corporation.
 */

@Entity
public class Review extends BaseEntity{

    private int rating;
    private String description;

    @ManyToOne
    private Course course;
    @ManyToOne
    private User reviewer;

    //todo: we are duplicating code here for every sigle entity. Share it?
    protected Review(){
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
