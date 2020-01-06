package com.vash.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * 注入配置配件使用@PropertySource()指定文件地址，若使用@Value()注入，则要配置一个propertySourcesPlaceholderConfigurer
 * todo 上面的configurer没有@Bean注入，依然可以运行
 * todo 注意 # $
 * 注入Properties还可以从Environment中获取
 * <p>
 * todo properties文件需要放在resources目录下，而不是java目录下，否则会报错，文件找不到
 * todo txt文件是否也要在resources下没测试
 */
@Configuration
@ComponentScan("com.vash.highlight_spring4.ch2.el")
@PropertySource("classpath:test.properties")
public class ElConfig {

    /**
     * 注入普通字符
     */
    @Value("normal String")
    private String normal;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入表达式结果
     */
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    /**
     * 注入其他bean属性
     */
    @Value("#{demoService.value}")
    private String fromAnother;

    /**
     * 注入文件资源
     */
    @Value("classpath:test.txt")
    private Resource testFile;

    /**
     * 注入网址资源
     */
    @Value("https://www.baidu.com")
    private Resource testUrl;

    /**
     * 注入配置文件
     */
    @Value("${demo.name}")
    private String demoName;

    @Autowired
    private Environment environment;

    @Bean
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
