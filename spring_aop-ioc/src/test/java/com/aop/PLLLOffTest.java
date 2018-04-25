package com.aop;

import com.service.PLLLOff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PLLLOffTest {

    private ApplicationContext context = null;
    private PLLLOff plllOff = null;

    @Test
    public void testPLLLOffAop(){
        plllOff.pllOff();
    }

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("beans.xml");
        plllOff = (PLLLOff)context.getBean("pllloff");
    }

}
