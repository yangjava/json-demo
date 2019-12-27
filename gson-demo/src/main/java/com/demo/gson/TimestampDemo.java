package com.demo.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;

public class TimestampDemo {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Timestamp.class, new TimestampAdapter())
                .create();
    }
}
