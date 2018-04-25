package com.spring.controller;

import com.common.ControllerEnum;
import com.common.SessionVar;
import com.common.StringUtil;
import com.spring.domin.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class UserControllerA extends BaseController {
    private final String HOME = ControllerEnum.View.getVar() + ControllerEnum.userAREST.getVar();
    private Logger logger = Logger.getLogger(toString());

    @Autowired
    private UserService userService;

    /**
     * 显示用户列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/user/userList.action")
    public String userList(Map<String, Object> map) {
        map.put("a1", "id");
        map.put("a2", "name");
        map.put("a3", "username");
        map.put("a4", "password");
        map.put("a5", "birthday");
        map.put("a6", "address");
        map.put("a7", "sex");
        map.put("a8", "account");
        map.put("a9", "group");
        map.put("a10", "jurisdiction");
        map.put("a11", "permission");
        map.put("a12", "role");
        map.put("a13", "age");
        map.put("page",1);
        logger.info("userList()" + map);
        return HOME + "userList";
    }

    /**
     * 转到开发页面
     * @param map
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/forwardUser.action", method = RequestMethod.GET)
    public String addUser(Map<String, Object> map, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        map.put("userA", new User());
        Map<String, Object> jurisdictions = new HashMap<String, Object>();
        jurisdictions.put("0", "user:select");
        jurisdictions.put("1", "user:update");
        jurisdictions.put("2", "user:insert");
        jurisdictions.put("3", "user:delete");
        jurisdictions.put("4", "user:show");
        map.put("jurisdictions", jurisdictions);
        List<String> roles = new ArrayList<>();
        roles.add("总督");
        roles.add("亲王");
        roles.add("藩王");
        roles.add("巡抚");
        roles.add("布政使");
        roles.add("按擦使");
        roles.add("节度使");
        roles.add("知府");
        roles.add("府知");
        roles.add("县令");
        roles.add("提督");
        roles.add("提辖");
        map.put("roles", roles);
        logger.info("addUser() forwardUser ");
        return HOME + "forwardUser";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user/login.action",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,HttpServletRequest request){
        logger.info("/user/login.action ");
        System.out.println(username+" "+password);
        String path = "";
        User user = null;
        try {
            if (!StringUtil.isNull(username)&&!StringUtil.isNull(password)){
                user = userService.login(username,password);
            }
            if (user==null){
                path= "redirect:/user/forwardLogin.action";
            }else {
                // 防止重复登陆
                ServletContext servletContext = request.getServletContext();
                List<String> usernameList = (List<String>)servletContext.getAttribute(""+SessionVar.USER_LIST.getVar());
                if (usernameList==null){//第一次登录
                    usernameList = new ArrayList<String>();
                    servletContext.setAttribute(""+SessionVar.USER_LIST.getVar(), usernameList);
                }// 不为null 判断用户是否已经在线
                boolean flag = StringUtil.checkOnline(usernameList,username);
                if (!flag){//用户不在线
                    usernameList.add(username);
                    request.getSession().setAttribute(SessionVar.USER_SESSION.getVar(),user);
                    path= "redirect:/user/userList.action";
                }else {// 用户在线
                    request.getSession().setAttribute("message", "该用户已经在线 ");
                    path= "redirect:/user/forwardLogin.action";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 转向登录页面
     * @return
     */
    @RequestMapping(value = "/user/forwardLogin.action")
    public String forwardLogin(){
        logger.info("/user/forwardLogin.action");
        return HOME + "loginUser";
    }

    /**
     * 添加用户
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/addUser.action", method = RequestMethod.POST)
    public String addUser(User user, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getCharacterEncoding());
        logger.info("" + user);
        userService.addUser(user);
        logger.info("addUser() addUser");
        return "redirect:/user/userList.action";
    }

    /**
     * json get data
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/showUserListJSON.action", method = RequestMethod.POST)
    public @ResponseBody
    List<User> showUserListJSON(@RequestParam(value = "page", defaultValue = "1") Integer page) throws Exception {
        logger.info("showUserListJSON()");
        List<User> users = userService.findAll(page);
        return users;
    }
}
