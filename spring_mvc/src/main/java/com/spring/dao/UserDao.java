package com.spring.dao;


import com.spring.domin.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws SQLException;

    public User findByID(Serializable id) throws SQLException;

    public List<User> findAll(int page, int var) throws SQLException;

    public void addUser(User user)throws SQLException;

    public User login(String username,String password)throws SQLException;
}
