package com.demo.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class GsonVersionDemo {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setVersion(1.1);
        Gson gson = builder.create();
        User user = new User();
        user.setId(1L);
        user.setName("杨京京");
        user.setAge(18);
        user.setIsMale(true);
        user.setVersion("1.1");
        user.setBirthDay(new Date());
        String jsonString = gson.toJson(user);
        System.out.println(jsonString);
    }
}
