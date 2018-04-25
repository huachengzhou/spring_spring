package com.ioc;

import com.ioc.config.CDConfigMore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDConfigMoreTest {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void play(){
        CDConfigMore cdConfigMore = context.getBean(CDConfigMore.class);
        cdConfigMore.getCompactDisc().play();
        cdConfigMore.getMedioPlay().play();
    }

}
