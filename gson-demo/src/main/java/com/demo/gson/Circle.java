package com.demo.gson;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Circle {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea() {
        return (radius*radius*3.14);
    }
}
