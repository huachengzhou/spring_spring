package com.dao.impl;

import com.dao.UserDao;
import com.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Lazy
    @Qualifier(value = "jdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll(int page, int var) throws SQLException {
        String sql = "select * from spring-mvc-user limit ?,?";//select * from user limit 3,7
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
    public void delete(Serializable id) throws SQLException {
        String sql = "DELETE from `spring-mvc-user` where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE `spring-mvc-user` u SET u.role=?,u.username=?,u.name=?,u.sex=?,u.account=?,u.address=?,u.`group`=?,u.password=?,u.jurisdiction=?,u.permission=?,u.age=?,u.birthday=? WHERE u.id=?";
        jdbcTemplate.update(sql, user.getRole() ,
                user.getUsername() ,
                user.getName() ,
                user.getSex() ,
                user.getAccount() ,
                user.getAddress() ,
                user.getGroup() ,
                user.getPassword() ,
                user.getJurisdiction() ,
                user.getPermission() ,
                user.getAge() ,
                user.getBirthday() ,
                user.getId());
    }

    @Override
    public void batch(List<User> users) throws SQLException {
        String sql = "insert into `spring-mvc-user`(id,birthday,name,username,password,address,account,`group`,sex,jurisdiction,permission,role,age) values((select UUID()),(select NOW()),?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> params = new ArrayList<>();
        for (User user:users){
            params.add(new Object[]{user.getName(), user.getUsername(), user.getPassword(), user.getAddress(), user.getAccount(), user.getGroup(), user.getSex(), user.getJurisdiction(), user.getPermission(), user.getRole(), user.getAge()});
        }
        jdbcTemplate.batchUpdate(sql,params);
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
