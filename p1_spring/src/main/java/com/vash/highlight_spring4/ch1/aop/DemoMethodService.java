package com.vash.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * 使用方法规则的被拦截类
 */
@Service
public class DemoMethodService {
    public void add() {
        System.out.println("method add");
    }
}
