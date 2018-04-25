package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Lazy
    @Qualifier(value = "jdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll(int page, int var) throws SQLException {
        String sql = "SELECT * from `spring-mvc-user` LIMIT ?,?";//SELECT * from `spring-mvc-user` LIMIT 22,6
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),page,var);
        return users;
    }

    @Override
    public void addUser(User user) throws SQLException {
        //insert into `spring-mvc-user`(id,birthday) VALUES( (select UUID()),(select NOW()) )
        String sql = "insert into `spring-mvc-user`(id,birthday,name,username,password,address,account,`group`,sex,jurisdiction,permission,role,age) values((select UUID()),(select NOW()),?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getName(), user.getUsername(), user.getPassword(), user.getAddress(), user.getAccount(), user.getGroup(), user.getSex(), user.getJurisdiction(), user.getPermission(), user.getRole(), user.getAge());
    }

    @Override
    public User login(String username,String password) throws SQLException {
        String sql = "SELECT * from `spring-mvc-user` where username =?";
        User user = null;
        List<User> users = jdbcTemplate.query(sql,new UserRowMapper(),username);
        for (User u:users){
            if (u.getPassword().equals(password))user = u;
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * from `spring-mvc-user`";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public User findByID(Serializable id) throws SQLException {
        String sql = "SELECT * from `spring-mvc-user` where id =?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return user;
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setAge(rs.getInt("age"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setPermission(rs.getString("permission"));
            user.setJurisdiction(rs.getString("jurisdiction"));
            user.setBirthday(rs.getDate("birthday"));
            user.setName(rs.getString("name"));
            user.setAddress(rs.getString("address"));
            user.setAccount(rs.getString("account"));
            user.setGroup(rs.getString("group"));
            user.setSex(rs.getString("sex"));
            user.setId(rs.getString("id"));
            return user;
        }
    }
}
