package me;

import com.spring.domin.User;
import com.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    private UserService userService;

    @Test
    public void find(){
        try {
            List<User> users = userService.findAll(5);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void login(){
        String username = "Owen";
        String password = "681544";
        try {
            User user = userService.login(username,password);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Before
    public void init(){
        userService = context.getBean(UserService.class);
    }
}
