package com.dao;



import com.domin.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws SQLException;

    public User findByID(Serializable id) throws SQLException;

    public List<User> findAll(int page, int var) throws SQLException;

    public void addUser(User user)throws SQLException;

    public void batch(List<User> users)throws SQLException;

    public void delete(Serializable id)throws SQLException;

    public void update(User user)throws SQLException;
}
