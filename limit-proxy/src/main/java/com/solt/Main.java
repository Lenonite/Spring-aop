package com.solt;

import com.solt.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        MyService myService=context.getBean(MyService.class);
        myService.greet("John");
        myService.sayHello();
    }
}
