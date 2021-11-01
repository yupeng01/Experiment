package com.nobug.experiment.tool.json;

import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class GsonDemo {
    public static void main(String[] args) {
        People people = new People()
                .setAge(19)
                .setName("李玉鹏");
        System.out.println(toJsonString(people));
        Map<String, Object> map = new HashMap();
        map.put("liyupeng", people);
        System.out.println(toJsonString(map));
    }

    public static String toJsonString (Object object) {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .create()
                .toJson(object);
    }
}
