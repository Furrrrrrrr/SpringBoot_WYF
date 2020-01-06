package com.vash.highlight_spring4.ch1.java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Object bean = context.getBean("useFunctionServiceBean");
        if (bean instanceof UseFunctionService) {
            ((UseFunctionService) bean).sayHello("test java config");
        } else {
            System.err.println("Unknown bean");
        }
        context.close();

    }
}
