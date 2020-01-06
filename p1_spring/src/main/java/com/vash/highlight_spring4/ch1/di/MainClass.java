package com.vash.highlight_spring4.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        FunctionService bean = context.getBean(FunctionService.class);
        bean.sayHello("test complete");
        // TODO: 2020/1/6 context为什么要close？
        context.close();
    }

}
