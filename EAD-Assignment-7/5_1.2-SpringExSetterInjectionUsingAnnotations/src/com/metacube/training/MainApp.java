package com.metacube.training;

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
        TextEditor textEditor = (TextEditor) factory.getBean("textEditor");
        textEditor.showStatus();
    }

}
