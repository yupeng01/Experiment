package com.nobug.experiment.juc.demo1;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 30日 15:09:00
 */
public class ShareVariablesDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            ShareVariablesEntity.num = 10;
            ShareVariablesEntity.result = true;
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(ShareVariablesEntity.num);
            System.out.println(ShareVariablesEntity.result);
        }).start();
    }
}
