package com.vash.highlight_spring4.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 开启spring对AspectJ代理支持？
 * todo
 */
@Configuration
@ComponentScan("com.vash.highlight_spring4.ch1.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
