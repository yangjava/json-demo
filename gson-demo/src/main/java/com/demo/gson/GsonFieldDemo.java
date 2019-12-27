package com.demo.gson;

import com.google.gson.Gson;

import java.util.Arrays;

public class GsonFieldDemo {

    public static void main(String args[]) {
        Gson gson = new Gson();
        Long id=1L;
        String name = "杨京京";
        Integer age =18;
        Boolean isMale=true;
        Double balance=100000.0;
        int[] marks = {100,90,85};

        //序列化成JSON
        System.out.println("{");
        System.out.println("id: " + gson.toJson(id) +",");
        System.out.println("name: " + gson.toJson(name) +",");
        System.out.println("age: " + gson.toJson(age) +",");
        System.out.println("isMale: " + gson.toJson(isMale) +",");
        System.out.println("balance: " + gson.toJson(balance) +",");
        System.out.println("marks:" + gson.toJson(marks));
        System.out.println("}");

        //反序列化成对象
        name = gson.fromJson("\"村长\"", String.class);
        age = gson.fromJson("15", Integer.class);
        isMale = gson.fromJson("false", Boolean.class);
        balance=gson.fromJson("200000.0", Double.class);
        marks = gson.fromJson("[100,90,85]", int[].class);

        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("isMale: " +isMale);
        System.out.println("balance: " +balance);
        System.out.println("marks:" + Arrays.toString(marks));
    }
}
