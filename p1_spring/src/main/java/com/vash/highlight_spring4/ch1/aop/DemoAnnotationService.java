package com.vash.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * 使用注解规则的被拦截类
 */
@Service
public class DemoAnnotationService {

    @Action("注解式拦截的add方法")
    public void add() {
        System.out.println("annotation add");
    }

}
