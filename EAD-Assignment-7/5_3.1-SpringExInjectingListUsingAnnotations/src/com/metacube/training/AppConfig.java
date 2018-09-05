package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        
        Course course = new Course();
        List<String> listOfSubjects = new ArrayList<String>();
        listOfSubjects.add("Physics");
        listOfSubjects.add("Chemistry");
        listOfSubjects.add("Mathematics");
        listOfSubjects.add("English");
        listOfSubjects.add("Computer Science");
        
        course.setListOfSubjects(listOfSubjects);
        
        return course;
    }

}
