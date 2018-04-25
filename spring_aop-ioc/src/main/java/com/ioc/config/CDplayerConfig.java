package com.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ioc.cd_impl")
public class CDplayerConfig {//ComponentScan注解默认会扫描当前所在package的路径
}
