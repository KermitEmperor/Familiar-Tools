package com.kermitemperor.familiartools.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class JsonUtils {

    public static int getColorFromJsonKey(JsonObject jsonObject, String key) {
        return Integer.parseInt(jsonObject.get(key).getAsString().toUpperCase(), 16);
    }

    public static ArrayList<String> JsonArray2ArrayList(JsonArray jsonArray) {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            array.add(jsonArray.get(i).getAsString());
        }
        return array;
    }

}
