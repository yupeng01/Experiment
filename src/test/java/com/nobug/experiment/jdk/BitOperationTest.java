package com.nobug.experiment.jdk;

public class BitOperationTest {
    public static void main(String[] args) {
        System.out.println( -1 << 29);
        System.out.println( 1 << 29);
        System.out.println( -1 << 29 | (1 << 29 - 1));
    }
}
