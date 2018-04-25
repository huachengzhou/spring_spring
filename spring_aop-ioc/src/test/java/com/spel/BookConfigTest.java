package com.spel;

import common.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zch.pojo.Book;

public class BookConfigTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void testBook(){
        Book book = (Book)context.getBean("bookA");
        logger.info(""+book);
    }
}
