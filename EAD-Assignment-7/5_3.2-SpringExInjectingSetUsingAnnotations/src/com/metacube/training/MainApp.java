package com.metacube.training;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author User5
 *
 */
public class MainApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = (Course) factory.getBean("course");
        Set<String> setOfSubjects = course.getSetOfSubjects();
        System.out.println("Set of subjects:");
        
        for(String subject: setOfSubjects)
            System.out.println(subject);

    }

}
