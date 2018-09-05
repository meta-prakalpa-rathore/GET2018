package com.metacube.training;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        
        Course course = new Course();
        Set<String> setOfSubjects = new HashSet<String>();
        setOfSubjects.add("Physics");
        setOfSubjects.add("Chemistry");
        setOfSubjects.add("Mathematics");
        setOfSubjects.add("English");
        setOfSubjects.add("Computer Science");
        
        course.setSetOfSubjects(setOfSubjects);
        
        return course;
    }

}
