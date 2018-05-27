package com.util;

import com.common.help.Zhou_String;
import org.springframework.util.StringUtils;

/**
 * Created by 13426 on 2018/5/27.
 */
public class Demo1 {
    public static void main(String[] args) {
        new Demo1().test1();;
    }

    private void test1(){
        String str  = "";
        boolean flag = StringUtils.isEmpty(str);
        System.out.println(flag);

        flag = StringUtils.hasText(str);
        System.out.println(flag);

        str = Zhou_String.toLowerCase(4);
        flag = StringUtils.hasLength(str);
        System.out.println(flag);

        str = "hello";
        str = StringUtils.deleteAny(str,"e");
        System.out.println(str);

        str = "gethte   eerreyeyr";
        str = StringUtils.trimAllWhitespace(str);
        System.out.println(str);
    }
}
