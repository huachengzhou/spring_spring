package com.ioc.config;

import com.domin.Counter;
import com.domin.Piano;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InstrumentConfig {

    @Bean
    public Piano getPiano(){
        Piano piano = new Piano();
        piano.setSound("天籁之音！！");
        return piano;
    }

    @Bean
    public Counter getCounter(){
        return  new Counter(12,"Shake it Off",getPiano());
    }
}
