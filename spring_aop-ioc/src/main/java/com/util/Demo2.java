package com.util;

import com.common.help.Zhou_StdRandom;
import com.common.help.Zhou_String;
import com.common.help.Zhou_Word;
import com.domin.User;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by 13426 on 2018/5/27.
 */
public class Demo2 {
    public static void main(String[] args) {
        new Demo2().test3();
    }

    public void test1(){
        HashMap<Object,Object> hashMap = null;
        boolean flag = ObjectUtils.isEmpty(hashMap);
        print(flag); //----->true

        hashMap = new HashMap<>();
        flag = ObjectUtils.isEmpty(hashMap);
        print(flag);//----->true

        hashMap.put("dd","dd");
        flag = ObjectUtils.isEmpty(hashMap);
        print(flag);//----->false
    }

    public void test2(){
        List<Object> list = null;
        boolean flag = ObjectUtils.isEmpty(list);
        print(flag);//----->true

        list = new ArrayList<>();
        flag = ObjectUtils.isEmpty(list);
        print(flag);//----->true

        list.add(new Object());
        flag = ObjectUtils.isEmpty(list);
        print(flag);//----->false
        return;
    }

    public void test3(){
        Object[] objects = null;
        boolean flag = ObjectUtils.isEmpty(objects);
        print(flag);//----->true

        objects = new Object[22];
        flag = ObjectUtils.isEmpty(objects);
        print(flag);//----->false
    }

    public void test4(){
        List<User> users = createPO();
        User user = createUser();
    }


    public void print(Object o){
        System.out.println("[ "+o+" ]");
    }

    public List<User> createPO(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(Zhou_StdRandom.uniform(2,56));
            user.setId(UUID.randomUUID().toString());
            user.setPassword(Zhou_String.toMath(6));
            user.setName(Zhou_Word.getChineseName());
            user.setUsername(Zhou_String.toLowerCase(5));
            users.add(user);
            if (i==5){
                users.add(createUser());
            }
        }
        return users;
    }

    public User createUser(){
        User user = new User();
        user.setId("123456");
        user.setPassword("123456");
        user.setAge(22);
        user.setName(Zhou_Word.getChineseName());
        user.setUsername(Zhou_String.toLowerCase(5));
        return user;
    }
}
