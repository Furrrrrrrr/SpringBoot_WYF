package com.vash.highlight_spring4.ch1.java_config;

public class UseFunctionService {

    FunctionService functionService;

    public UseFunctionService setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
        return this;
    }

    public void sayHello(String target) {
        functionService.sayHello(target);
    }
}
