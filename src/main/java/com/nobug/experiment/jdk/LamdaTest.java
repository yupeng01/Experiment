package com.nobug.experiment.jdk;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LamdaTest {

    public static List<String> filterList (List<String> list) {
        return list.stream().filter(item -> Objects.equals(item, "hahaa")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hahaa");
        list.add("hahaa");
        list.add("hahaa");
        list.add("hahaab");
        list.add("hahaab");
        list.add("hahaab");
        list.add("hahaabc");
        list.add("hahaabc");
        list.add("hahaabc");
        List<String> result = filterList(list);
        System.out.println(JSON.toJSONString(list));

        System.out.println(JSON.toJSONString(result));
    }
}
