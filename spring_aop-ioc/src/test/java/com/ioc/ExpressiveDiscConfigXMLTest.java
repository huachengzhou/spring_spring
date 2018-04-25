package com.ioc;

import com.domin.BlankDisc;
import common.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExpressiveDiscConfigXMLTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void blankdisc(){
        BlankDisc blankDisc = (BlankDisc)context.getBean("blankDisc");
        logger.info(""+blankDisc);
    }
}
