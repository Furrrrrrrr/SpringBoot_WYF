package com.vash.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@ComponentScan("com.vash.highlight_spring4.ch2.el")
@PropertySource("classpath:com/vash/highlight_spring4/ch2/el/test.properties")
public class ElConfig {

    @Value("normal String")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    @Value("#{demoService.another}")
    private String fromAnother;

    @Value("classpath:com/vash/highlight_spring4/ch2/el/test.txt")
    private Resource testFile;

    @Value("https://www.baidu.com")
    private Resource testUrl;

    @Value("${demo.name}")
    private String demoName;

    @Autowired
    private Environment environment;

    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.err.println(normal);
            System.err.println(osName);
            System.err.println(randomNumber);
            System.err.println(fromAnother);
            System.err.println(IOUtils.toString(testFile.getInputStream()));
            System.err.println(IOUtils.toString(testUrl.getInputStream()));
            System.err.println(demoName);
            System.err.println(environment.getProperty("demo.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
