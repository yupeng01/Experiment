package com.nobug.experiment.jdk;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 由stream未关闭引起的OOM问题
 * @createTime 2021年 05月 17:10:00
 */
public class StreamDemo {
    public static void streamNotClose () throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/liyupeng/Downloads/1.txt"));
        char[] tmp = new char[1024];
        while (true) {
            reader.read(tmp);
            System.out.println(tmp);
        }
    }
    public static void streamIsCLose () throws IOException {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/liyupeng/Downloads/1.txt"));) {
            char[] tmp = new char[1024];
            while (true) {
                reader.read(tmp);
                System.out.println(tmp);
            }
        }
    }
    public static void main(String[] args) {
        try {
            streamNotClose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
