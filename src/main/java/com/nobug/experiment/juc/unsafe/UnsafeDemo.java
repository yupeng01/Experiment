package com.nobug.experiment.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;

public class UnsafeDemo {
    public static int state = 1;
    private static final Unsafe unsafe = UnsafeDemo.getUnsafe();
    static {
        System.out.println(unsafe);
        System.out.println(Unsafe.getUnsafe());
    }

    public static Unsafe getUnsafe () {
        try {
            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getUnsafe());
    }
}
