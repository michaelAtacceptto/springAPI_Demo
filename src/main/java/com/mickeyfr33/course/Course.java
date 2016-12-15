package com.mickeyfr33.course;

import com.mickeyfr33.core.BaseEntity;
import com.mickeyfr33.review.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelsmith on 12/14/16.
 * Copyright Acceptto Corporation.
 */

@Entity
public class Course extends BaseEntity {

    private String title;
    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course(){
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String url) {
        //calls the constructor above and initializes the ID field as null, which is later auto generated.
        this();
        this.title = title;
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviews.add(review);
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
