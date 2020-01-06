package com.vash.highlight_spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    @Autowired
    FunctionService functionService;

    public void sayHello(String target) {
        functionService.sayHello(target);
    }

}
