package com.dao;

import com.common.help.Zhou_StdRandom;
import com.common.help.Zhou_Word;
import com.dao.impl.UserDaoImpl;
import com.domin.User;
import common.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDaoTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = Logger.getLogger(getClass());
    private UserDao userDao = null;

    @Test
    public void addUser()throws Exception{
        String[] roles = new String[]{"普通用户","学生","底层老百姓","士族"};
        User user = new User();
        user.setAccount(Zhou_StdRandom.uniform(2000,100000)+"");
        user.setAddress("china");
        user.setAge(Zhou_StdRandom.uniform(0,100));
        user.setGroup("中石油");
        user.setJurisdiction("都督");
        user.setPassword(Zhou_StdRandom.uniform(100000,999999)+"");
        user.setName(Zhou_Word.getChineseName_Random());
        user.setUsername(Zhou_Word.getEnglishName());
        user.setPermission("user:remove");
        user.setRole(roles[Zhou_StdRandom.uniform(0,roles.length-1)]);
        user.setSex(new Random().nextBoolean()?"man":"woman");
        userDao.addUser(user);
    }
    @Test
    public void update()throws Exception{
        String id = "1e6d0a57-39b3-11e8-8103-74e543dde5e3";
        User user = userDao.findByID(id);
        user.setName("sgsdgd");
        userDao.update(user);
    }

    @Test
    public void delete()throws Exception{
        String id = "1e6d0a57-39b3-11e8-8103-74e543dde5e3";
        userDao.delete(id);
    }

    @Test
    public void batch()throws Exception{
        List<User> users = new ArrayList<>();
        String[] roles = new String[]{"普通用户","学生","底层老百姓","士族"};
        User user = null;
        for (int i = 0; i < 1000; i++) {
            user = new User();
            user.setAccount(Zhou_StdRandom.uniform(2000,100000)+"");
            user.setAddress("china");
            user.setAge(Zhou_StdRandom.uniform(0,100));
            user.setGroup("中石油");
            user.setJurisdiction("都督");
            user.setPassword(Zhou_StdRandom.uniform(100000,999999)+"");
            user.setName(Zhou_Word.getChineseName_Random());
            user.setUsername(Zhou_Word.getEnglishName());
            user.setPermission("user:remove");
            user.setRole(roles[Zhou_StdRandom.uniform(0,roles.length-1)]);
            user.setSex(new Random().nextBoolean()?"man":"woman");
            users.add(user);
        }
        userDao.batch(users);
    }

    @Before
    public void init(){
        userDao = context.getBean(UserDao.class);
    }
}
