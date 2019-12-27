package com.demo.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;

public class TypeTokenDemo {

    public static void main(String args[]) {
        //创建Gson对象
        Gson gson = new Gson();

        Shape<Circle> shape = new Shape<Circle>();
        Circle circle = new Circle(5.0);
        shape.setShape(circle);

        Type shapeType = new TypeToken<Shape<Circle>>() {}.getType();

        //序列化
        String jsonString = gson.toJson(shape, shapeType);
        System.out.println(jsonString);

        //反序列化
        Shape shape1 = gson.fromJson(jsonString, Shape.class);
        System.out.println(shape1.get().getClass());
        System.out.println(shape1.get().toString());
        System.out.println(shape1.getArea());
        Shape shape2 = gson.fromJson(jsonString, shapeType);
        System.out.println(shape2.get().getClass());
        System.out.println(shape2.get().toString());
        System.out.println(shape2.getArea());
    }


}
