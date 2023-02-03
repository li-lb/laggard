package com.lilb.laggard.practice;

import com.lilb.laggard.entity.User;
import org.springframework.util.ObjectUtils;

public class Demo {
    public static void main(String[] args) {
        User user = new User();
        String s = ObjectUtils.nullSafeClassName(user);
        System.out.println(s);
    }
}
