package com.zuoye.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class AopTest {
    private static Logger LOG = LoggerFactory.getLogger(AopTest.class);

    @Pointcut("execution(* com.zuoye.controller.InfoController.queryAll(..))")

    public void quaryAll() {

    }

    @Pointcut("execution(* com.zuoye.controller.InfoController.updateById(..))")
    public void updateById() {

    }

    @Pointcut("execution(* com.zuoye.controller.InfoController.delete(..))")
    public void delete() {

    }

    @Before("quaryAll()")
    public void beforequaryAll(JoinPoint joinPoint) {
        LOG.info("查询开始了");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        System.out.println("前置通知:" + className + "类的" + methodName + "方法执行了...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        System.out.println("用户是:" + session.getAttribute("telephone"));
    }

    @After("quaryAll()")
    public void afterqueryAll(JoinPoint joinPoint) {
        LOG.info("查询结束");
    }

    @Before("updateById()")
    public void beforeupdateById() {
        LOG.info("开始修改");

    }

    @Around("quaryAll()")
    public Object aroundquaryAll(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AOP around");
        Object result = point.proceed();
        System.out.println("AOP around!!!!!!!!!!!!!!!");
        return result;

    }

    @AfterReturning(value = "quaryAll()", returning = "str")
    public void log(Object str) {
        System.out.println(str);
    }


    @After("updateById()")
    public void afterupdateById() {
        LOG.info("修改结束");
    }

    @Before("delete()")
    public void beforedelete() {
        LOG.info("删除开始");
    }

    @After("delete()")
    public void afterdelete() {
        LOG.info("删除结束");
    }

    @Pointcut("execution(* com.zuoye.service.UserService.*(..))")
    public void login() { }

    @Around("login()")
    public void lsjdfksdlf(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName());
        joinPoint.proceed();
        System.out.println("执行完了");
    }
}
