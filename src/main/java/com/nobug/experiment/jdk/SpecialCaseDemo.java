package com.nobug.experiment.jdk;

public class SpecialCaseDemo {

    public static void checkIsEquals () {
        System.out.println(0.1 * 3 == 0.3);
        System.out.println(0.1 * 3);
        System.out.println(0.3);
    }

    public static void main(String[] args) {
        checkIsEquals();
    }
}
