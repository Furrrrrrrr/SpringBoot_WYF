package com.vash.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService single1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService single2 = context.getBean(DemoSingletonService.class);
        DemoPrototypeService prototype1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService prototype2 = context.getBean(DemoPrototypeService.class);
        System.err.println("single:1与2相等：" + Objects.equals(single1, single2));
        System.err.println("prototyep:1与2相等：" + Objects.equals(prototype1, prototype2));
        context.close();
    }
}
