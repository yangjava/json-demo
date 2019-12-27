package com.demo.gson;

import com.google.gson.*;

public class JsonParserDemo {

    public static void main(String[] args) {
        String jsonString = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0,\"marks\": [100,90,85]}";
        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(jsonString);

        if (rootNode.isJsonObject()) {
            JsonObject details = rootNode.getAsJsonObject();

            JsonElement idNode = details.get("id");
            System.out.println("id: " + idNode.getAsLong());

            JsonElement nameNode = details.get("name");
            System.out.println("name: " + nameNode.getAsString());

            JsonElement ageNode = details.get("age");
            System.out.println("age: " + ageNode.getAsInt());

            JsonElement birthDayNode = details.get("birthDay");
            System.out.println("birthDay: " + birthDayNode.getAsString());

            JsonElement isMaleNode = details.get("isMale");
            System.out.println("isMale: " + isMaleNode.getAsBoolean());

            JsonElement balanceNode = details.get("balance");
            System.out.println("balance: " +balanceNode.getAsDouble());

            JsonArray marks = details.getAsJsonArray("marks");

            for (int i = 0; i < marks.size(); i++) {
                JsonPrimitive value = marks.get(i).getAsJsonPrimitive();
                System.out.print(value.getAsInt() + " ");
            }
        }

    }
}
