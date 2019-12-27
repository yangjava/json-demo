package com.demo.gson;

class Shape <T> {
    public T shape;

    public void setShape(T shape) {
        this.shape = shape;
    }
    public T get() {
        return shape;
    }
    public double getArea() {
        if(shape instanceof Circle) {
            return ((Circle)shape).getArea();
        } else {
            return 0.0;
        }
    }
}

