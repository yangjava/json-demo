package com.demo.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

public class JsonReaderDemo {

    public static void main(String[] args) {

        String jsonString = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0}";
        JsonReader reader = new JsonReader(new StringReader(jsonString));
        try {
            readJsonObject(reader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readJsonObject(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()){
            JsonToken token = reader.peek();
            if(JsonToken.BEGIN_ARRAY.equals(token)){
                readJsonArray(reader);
            }
            if(JsonToken.END_OBJECT.equals(token)){
                reader.endObject();
                return;
            }else{
                readJsonToken(token,reader);
            }
        }

    }


    private  static void readJsonToken(JsonToken token,JsonReader reader)throws IOException{
        String fieldname = null;
        if (token.equals(JsonToken.NAME)) {
            fieldname = reader.nextName();
        }
        if ("id".equals(fieldname)) {
            token = reader.peek();
            System.out.println("id: "+reader.nextLong());
        }
        if ("name".equals(fieldname)) {
            token = reader.peek();
            System.out.println("name: "+reader.nextString());
        }
        if("age".equals(fieldname)) {
            token = reader.peek();
            System.out.println("age: "+reader.nextInt());
        }
        if("birthDay".equals(fieldname)) {
            token = reader.peek();
            System.out.println("birthDay: "+reader.nextString());
        }
        if("isMale".equals(fieldname)) {
            token = reader.peek();
            System.out.println("isMale: "+reader.nextBoolean());
        }
        if("balance".equals(fieldname)) {
            token = reader.peek();
            System.out.println("balance: "+reader.nextDouble());
        }
    }

    private  static void readJsonArray(JsonReader reader) throws IOException {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                readJsonObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else {
                System.out.print(reader.nextInt() + " ");
            }
        }
    }


}
