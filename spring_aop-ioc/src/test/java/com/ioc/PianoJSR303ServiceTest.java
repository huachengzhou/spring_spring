package com.ioc;

import com.service.PianoJSR303Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PianoJSR303ServiceTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void plano(){
        PianoJSR303Service pianoJSR303Service = (PianoJSR303Service)context.getBean("pianoJSR303Service");
        pianoJSR303Service.piano();
    }
}
