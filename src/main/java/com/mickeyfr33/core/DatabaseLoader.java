package com.mickeyfr33.core;

import com.mickeyfr33.course.Course;
import com.mickeyfr33.course.CourseRepository;
import com.mickeyfr33.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by MichaelSmith on 12/15/16.
 */

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courses;

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Course course = new Course("Java Basics", "https://teamtreehouse.com/library/java-basics");
        courses.save(course);
        course.addReview(new Review(3, "You ARE a dork!!!"));
        courses.save(course);
    }

}
