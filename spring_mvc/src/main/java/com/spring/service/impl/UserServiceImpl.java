package com.spring.service.impl;

import com.common.NUM;
import com.spring.dao.UserDao;
import com.spring.domin.User;
import com.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private final int num = Integer.parseInt(NUM.PageNUm.getVar());
    @Resource
    private UserDao userDao;

    @Override
    public User findById(Serializable id) throws Exception {
        return userDao.findByID(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.login(username,password);
        if (user.getPassword().equals(password)){
            return user;
        }else {
            throw new SQLException();
        }
    }

    @Override
    public List<User> findAll(int page) throws Exception {
        if (findAll().size()<num){
            return userDao.findAll(0, num);
        }
        return userDao.findAll(page, num);
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }
}
