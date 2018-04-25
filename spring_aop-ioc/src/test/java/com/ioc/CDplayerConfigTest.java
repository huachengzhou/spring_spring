package com.ioc;

import com.ioc.config.CDplayerConfig;
import com.service.cd.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDplayerConfig.class)
public class CDplayerConfigTest {

    @Qualifier(value = "compactDisc")
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void play(){
        compactDisc.play();
    }
}
