package com.demo.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        //创建一个Gson对象
        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
        Gson gson = builder.create();

        //将对象序列化为JSON
        User user = new User();
        user.setId(1L);
        user.setName("杨京京");
        user.setAge(18);
        user.setIsMale(true);
        user.setBirthDay(new Date());
        user.setBalance(100000.00);
        String jsonString = gson.toJson(user);

        System.out.println("========");
        System.out.println(jsonString);
        System.out.println("========");
        //将JSON反序列化为对象
        String s = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0}";
        User userInfo = gson.fromJson(jsonString, User.class);
        System.out.println(userInfo.toString());
    }
}
