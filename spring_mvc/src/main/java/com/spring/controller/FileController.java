package com.spring.controller;

import com.common.ControllerEnum;
import com.common.UpFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Logger;

@Controller
public class FileController {

    private final String VIEW_HOME = ControllerEnum.View.getVar()+ControllerEnum.FILE.getVar();
    private Logger logger = Logger.getLogger(toString());

    @RequestMapping(value = "/file/ForWard.action")
    public String forwardFile(){
        logger.info("forwardFile()");
        return VIEW_HOME+"forwardUpload";
    }

    @RequestMapping(value = "/file/upload.action",method = RequestMethod.POST)
    public String fileupload(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/") + "files/"+file.getOriginalFilename();
        logger.info(path);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            if (file.getSize()>0){
                UpFileUtil.uploadFile(path,file.getInputStream());
                out = response.getWriter();
            }
            logger.info("success!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/springmvc/home";
    }
}
