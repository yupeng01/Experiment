package com.nobug.experiment.designmodel.singlecase;

import java.io.Serializable;

public class SingleCase implements Serializable, Cloneable{
    private volatile static SingleCase instance = null;
    private final static Object sync = new Object();
    private static boolean flag = true;

    private SingleCase () {
        if (flag) {
            synchronized (SingleCase.class) {
                flag = false;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public static SingleCase getInstance () {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new SingleCase();
                    flag = false;
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    private Object readResolve () {
        return instance;
    }
}
