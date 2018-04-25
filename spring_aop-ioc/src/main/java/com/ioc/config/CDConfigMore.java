package com.ioc.config;

import com.service.cd.CompactDisc;
import com.service.cd.MedioPlay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {CDConfig.class,CDplayerConfig.class})
@Configuration
public class CDConfigMore {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private MedioPlay medioPlay;

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }

    public MedioPlay getMedioPlay() {
        return medioPlay;
    }
}
