package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Exam exam = (Exam) factory.getBean("exam");
        Map<String, Double> averageMarksOfSubjects = exam.getAverageMarksOfSubjects();
        System.out.println("Average marks of subjects:");
        System.out.println("Subject\t\tAverage Marks");
        
        for(String subject: averageMarksOfSubjects.keySet())
            System.out.println(subject + "\t\t" + averageMarksOfSubjects.get(subject));
    }

}
