package com.demo.gson;

import com.google.gson.Gson;

import java.util.Arrays;

public class GsonArrayDemo {

    public static void main(String args[]) {
        Gson gson = new Gson();
        int[] ages = {13,14,15};
        String[] names = {"张三","李四","王五"};

        //序列化
        System.out.print("{");
        System.out.print("ages:" + gson.toJson(ages) + ",");
        System.out.print("names:" + gson.toJson(names));
        System.out.println("}");

        //反序列化
        ages = gson.fromJson("[18,19,20]", int[].class);
        names = gson.fromJson("[\"侯六\",\"杨七\",\"冯八\"]", String[].class);
        System.out.println("ages:" + Arrays.toString(ages));
        System.out.println("names:" + Arrays.toString(names));
    }


}
