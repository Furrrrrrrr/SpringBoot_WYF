package com.vash.highlight_spring4.ch1.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此处没有用@ComponentScan 因为所用的bean都在此类中
 */
@Configuration
public class JavaConfig {

    /**
     * bean的名称是方法名
     *
     * @return
     */
    @Bean
    public FunctionService functionServiceBean() {
        return new FunctionService();
    }

    /**
     * 调用本类方法，组装useFunctionServiceBean
     *
     * @return
     */
    @Bean
    public UseFunctionService useFunctionServiceBean() {
        return new UseFunctionService().setFunctionService(functionServiceBean());
    }

    /**
     * 只要spring中有此bean就可以在声明方法的参数中写入
     * 注掉functionServiceBean()方法中的@Bean后，形参报错可以验证
     *
     * @param functionService
     * @return
     */
    @Bean
    public UseFunctionService useFunctionServiceBean(FunctionService functionService) {
        return new UseFunctionService().setFunctionService(functionService);
    }


}
