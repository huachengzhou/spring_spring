package com.ioc.cd_impl;

import com.common.help.Zhou_StdRandom;
import com.common.help.Zhou_String;
import com.service.cd.CompactDisc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named(value = "compactDisc")//Component等同于
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//单例模式
//@Component(value = "compactDisc")//Named 等同于
public class SgtPeppers implements CompactDisc {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void play() {
        int num = Zhou_StdRandom.uniform(5,20);
        String uuid = Zhou_String.toUpperCase(num);
        logger.info("------------------>>");
        for (int i = 0; i < Zhou_StdRandom.uniform(3,8); i++) {
            logger.info("<==  . ............");
        }
        logger.info(""+uuid);
    }
}
