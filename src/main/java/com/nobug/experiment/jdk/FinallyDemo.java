package com.nobug.experiment.jdk;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(getValue());
    }

    public static int getValue () {
        int i = 0;
        try {
            i = 2;
            return i;
        } finally {
            i = 3;
        }
    }
}
