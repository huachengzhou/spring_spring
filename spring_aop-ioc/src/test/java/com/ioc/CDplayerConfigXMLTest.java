package com.ioc;

import com.service.cd.CompactDisc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDplayerConfigXMLTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private CompactDisc compactDisc;

    @Test
    public void play(){
        compactDisc.play();
        /**
         * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'compactDisc' is defined
         */
        //必须在xml中扫描 CDplayerConfig class 所在的package或者直接配置为bean
        //在xml配置以后bean生效而CDplayerConfig中的ComponentScan会扫描SgtPeppers package这样就得到了我们需要的bean
    }

    @Before
    public void init(){
        compactDisc = (CompactDisc)context.getBean("compactDisc");
    }
}
