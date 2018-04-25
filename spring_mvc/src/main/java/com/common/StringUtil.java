package com.common;

import java.util.List;

public class StringUtil {
    public static final boolean isNull(String var){
        boolean flag = false;
        if (var==null||var.length()<=0||var==""){
            flag = true;
        }
        return flag;
    }

    /**
     *
     * @param usernameList
     * @param username
     * @return
     */
    public static final boolean checkOnline(List<String> usernameList, String username) {
        boolean flag = false;
        if(usernameList.size()==0){//第一次为null没有一个用户,该用户未在线
            usernameList.add(username);
        }else {
            for(String u:usernameList){
                if(u.equals(username)){//该用户在线
                    flag = true;//已经登陆过了
                    return flag;
                }
            }
            //该用户不在线
            usernameList.add(username);
        }
        return flag;
    }

}
