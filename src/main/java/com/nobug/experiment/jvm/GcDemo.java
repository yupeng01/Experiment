package com.nobug.experiment.jvm;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 28日 11:57:00
 */
public class GcDemo {
    public static void main(String[] args) {
        int num = 1024 * 1024;
        byte[] data = new byte[num];
        data = null;
        System.gc();
    }
}
