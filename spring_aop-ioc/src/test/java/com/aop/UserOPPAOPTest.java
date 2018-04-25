package com.aop;

import com.service.UserOPP;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserOPPAOPTest {

    private ApplicationContext context = null;

    private UserOPP userOPP = null;

    @Test
    public void testuseropp(){
        userOPP.isFFF("hello!");
    }

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("beans.xml");
        userOPP = (UserOPP)context.getBean("useropp");
    }
}
