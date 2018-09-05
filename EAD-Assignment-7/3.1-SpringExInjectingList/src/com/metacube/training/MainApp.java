package com.metacube.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author User5
 *
 */
public class MainApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        Course course = (Course) factory.getBean("course");
        List<String> listOfSubjects = course.getListOfSubjects();
        System.out.println("List of subjects:");
        
        for(String subject: listOfSubjects)
            System.out.println(subject);

    }

}
