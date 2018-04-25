package com.ioc.config;

import com.ioc.cd_impl.MedioPlayImpl;
import com.service.cd.MedioPlay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean
    public MedioPlay getMedioPlay(){
        return new MedioPlayImpl();
    }
}
