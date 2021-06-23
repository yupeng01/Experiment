package com.nobug.experiment.test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 23日 11:59:00
 */
public class TestInstance {
    public static void main(String[] args) {
        testInstanceV1();
    }

    private static void testInstanceV1() {
        ArrayList list = new ArrayList();
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof Object);
        System.out.println(ArrayList.class.isInstance(list));
        Object o = new Object();
        System.out.println(ArrayList.class.isInstance(o));
        System.out.println(Object.class.isInstance(list));
        System.out.println(ArrayList.class.isAssignableFrom(AbstractList.class));
        System.out.println(ArrayList.class.isAssignableFrom(List.class));
        System.out.println(Object.class.isAssignableFrom(ArrayList.class));
        AbstractList list1 = new ArrayList();
        ArrayList list2 = (ArrayList) list1;
    }
}
