package com.vash.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Aspect 注解声明一个切面
 * spring容器管理
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 声明切点
     */
    @Pointcut("@annotation(com.vash.highlight_spring4.ch1.aop.Action)")
    public void annotationPointCut() {
    }

    /**
     * @param point
     * @After声明一个建言，使用@Pointcut声明的切点 todo
     */
    @After("annotationPointCut()")
    public void after(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.err.println("注解式拦截：" + annotation.value());

    }

    /**
     * @Before声明一个建言，使用拦截规则作为参数 todo 注意此处 execution(方法表达式)
     * todo 例如： execution(* com.sample.service.impl..*.*(..))
     * 第一个“*” 返回值类型
     * com.sample.service.impl AOP所切的服务的包名，即，我们的业务部分
     * 包名后面的“..” 表示当前包及子包
     * 第二个“*” 表示类名，*即所有类。此处可以自定义，下文有举例
     * .*(..) 表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
    @Before("execution(* com.vash.highlight_spring4.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String name = method.getName();
        System.err.println("方法规则拦截：" + name);
    }

}
