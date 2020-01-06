package com.vash.highlight_spring4.ch1.aop;

import java.lang.annotation.*;

/**
 * 拦截规则注释
 * 注解和xml一样，本身没有功能，是一种元数据（解释数据的数据）
 * 注解的功能来自用此注解的地方
 *
 * @author
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    /**
     * 只有value可省略？
     *
     * @return
     */
    String value();
}
