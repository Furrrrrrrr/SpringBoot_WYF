package com.vash.highlight_spring4.ch1.di;

import org.springframework.stereotype.Service;


@Service
public class FunctionService {

    public void sayHello(String target) {
        System.err.println("hello:" + target);
    }
}
