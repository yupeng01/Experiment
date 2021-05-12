package com.nobug.experiment.jdk;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description HashMap和HashTable的一些Demo
 * @createTime 2021年 05月 11:34:00
 */
public class HashMapDemo {
    private static Map<String, Object> initHashMap () {
        Map<String,Object> hashMap = new HashMap<>();
        IntStream.range(1, 13).forEach(item -> hashMap.put(String.valueOf(item), item));
        return hashMap;
    }
    private static void testDemo1 () {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(null, "null值");
        System.out.println(hashMap.get(null));
        hashMap.put("","-- --");
        System.out.println(hashMap.get(""));
        hashMap.put(" ", "---  ---");
        System.out.println(hashMap.get(" "));
        hashMap.put("  ", "---   ---");
        System.out.println(hashMap.get("  "));

        try {
            Map<String, Object> hashTable = new Hashtable<>();
            hashTable.put(null, "null值");
            System.out.println(hashTable.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Map<String, Object> treeMap = new TreeMap<>();
            treeMap.put(null, "null值");
            System.out.println(treeMap.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(null, "null值");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> hashMap01 = initHashMap();
        hashMap01.put("13", 13);
    }

    private static Map<String, Object> initBigMap () {
        Map<String, Object> hashMap = new HashMap<>();
        IntStream.range(0,3000000).forEach(item -> hashMap.put(item+"", item));
        return hashMap;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Map<String, Object> hashMap = initBigMap();
        long endTime1 = System.currentTimeMillis();
        System.out.println(hashMap.get("1234"));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime);
        System.out.println(endTime2 - endTime1);
    }
}
