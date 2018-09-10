package com.metacube.training;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Exam exam() {
        
        Exam exam = new Exam();
        Map<String, Double> averageMarksOfSubjects = new HashMap<String, Double>();
        averageMarksOfSubjects.put("Physics", 75.5);
        averageMarksOfSubjects.put("Chemistry", 80.0);
        averageMarksOfSubjects.put("Mathematics", 78.5);
        averageMarksOfSubjects.put("English", 69.5);
        averageMarksOfSubjects.put("Computer Science", 81.5);
        
        exam.setAverageMarksOfSubjects(averageMarksOfSubjects);
        
        return exam;
    }

}
