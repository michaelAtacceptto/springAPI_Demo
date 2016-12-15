package com.mickeyfr33.core;

import com.mickeyfr33.course.Course;
import com.mickeyfr33.course.CourseRepository;
import com.mickeyfr33.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        String[] templates = {
                "Up and running with with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s"
        };

        String[] buzzwords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate"
        };

        List<Course> allCourses = new ArrayList<>();

        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://www.example.com");
                    c.addReview(new Review(i % 5, String.format("Moar %s please!!!", buzzword)));
                    allCourses.add(c);
        });

        courses.save(allCourses);

    }

}
