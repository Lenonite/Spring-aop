package com.demo;

import com.demo.service.ComplexAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        ComplexAction action=context.getBean(ComplexAction.class);
        action.takeAction();
    }
}
