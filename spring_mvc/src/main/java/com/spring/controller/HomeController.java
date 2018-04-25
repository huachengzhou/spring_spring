package com.spring.controller;

import com.common.ControllerEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@RequestMapping(value = "/springmvc")
@Controller
public class HomeController {
    private final String HOME = ControllerEnum.View.getVar();
    private Logger logger = Logger.getLogger(toString());

    @RequestMapping(value = "/home")
    public String home(){
        logger.info("home()");
        return HOME+"home";
    }
}
