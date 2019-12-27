package com.demo.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class GsonCollection {

    public static void main(String args[]) {
        Gson gson = new Gson();
        Collection<Integer> ages = new ArrayList<Integer>();
        ages.add(13);
        ages.add(14);
        ages.add(15);

        //序列化
        System.out.print("{");
        System.out.print("ages:" + gson.toJson(ages));
        System.out.println("}");

        //反序列化
        Type listType = new TypeToken<Collection<Integer>>() {
        }.getType();
        ages = gson.fromJson("[17,18,19]", listType);
        System.out.println("ages:" + ages);
    }

}
