package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Person person1 = (Person) factory.getBean("person");
        System.out.println("Name of person1 : " + person1.getName());
        person1.setName("Rathore");
        System.out.println("Updated name of person1 : " + person1.getName());
        
        Person person2 = (Person) factory.getBean("person");
        System.out.println("Name of person2 : " + person2.getName());

    }

}
