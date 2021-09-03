package com.nobug.experiment.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static int state = 1;
    private static final Unsafe unsafe = UnsafeDemo.getUnsafe();
    private static final long stateOffSet;
    static {
        try {
            stateOffSet = unsafe.objectFieldOffset(
                    UnsafeDemo.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            throw new Error();
        }
    }

    public static Unsafe getUnsafe () {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(stateOffSet);
    }
}
