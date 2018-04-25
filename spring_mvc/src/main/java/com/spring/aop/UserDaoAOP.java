package com.spring.aop;

import com.alibaba.druid.pool.DruidDataSource;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.logging.Logger;

@Component
@Aspect
public class UserDaoAOP {

    private Logger logger = Logger.getLogger(toString());

    @Autowired
    private DruidDataSource druidDataSource;

    @Pointcut(value = "execution (* com.spring.service.UserService.*(..))")
    public void point(){

    }

    @Before(value = "point()")
    public void before(){
    }

    @After(value = "point()")
    public void after(){
    }

    @AfterReturning(value = "point()",returning = "o")
    public void afterReturn(Object o){
        logger.info("params:"+o);
    }

    @AfterThrowing(value = "point()",throwing = "e")
    public void afterThrow(Throwable e){
    }
}
