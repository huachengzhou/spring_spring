package com.spring.service;

import com.spring.domin.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {
    public List<User> findAll() throws Exception;

    public User findById(Serializable id) throws Exception;

    public List<User> findAll(int page) throws Exception;

    public void addUser(User user)throws Exception;

    public User login(String username,String password)throws Exception;
}
