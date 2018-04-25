package com.ioc.cd_impl;

import com.common.help.Zhou_StdRandom;
import com.common.help.Zhou_String;
import com.service.cd.MedioPlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedioPlayImpl implements MedioPlay {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void play() {
        int num = Zhou_StdRandom.uniform(5,20);
        String uuid = Zhou_String.toUpperCase(num);
        logger.info("------------------>>");
        for (int i = 0; i < Zhou_StdRandom.uniform(3,8); i++) {
            logger.info("---------------------------> "+i++);
        }
        logger.info(""+uuid);
    }
}
