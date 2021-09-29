package com.nobug.experiment.designmodel.singlecase;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.stream.IntStream;

public class Test {

    private static void oneHundredTimesTest() {
        IntStream.range(1, 101).forEach(i -> {
            new Thread(() -> {
                System.out.println(SingleCase.getInstance());
            }).start();
        });
    }

    public static void main(String[] args) {

        serilize();

        cloneObject();

        System.out.println(SingleCase.getInstance());

        reflex();
    }

    private static void cloneObject() {
        try {
            Object clone = SingleCase.getInstance().clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void serilize() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(SingleCase.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bis);
            System.out.println(ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void reflex() {
        try {
            Constructor<SingleCase> constructor = SingleCase.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            System.out.println(constructor.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
