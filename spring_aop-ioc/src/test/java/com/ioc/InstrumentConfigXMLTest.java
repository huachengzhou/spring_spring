package com.ioc;

import com.domin.Counter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstrumentConfigXMLTest {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void plano(){
        Counter counter = context.getBean(Counter.class);
        System.out.println(counter.getInstrument());
    }

}
