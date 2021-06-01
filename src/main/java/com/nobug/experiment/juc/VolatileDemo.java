package com.nobug.experiment.juc;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 26日 10:30:00
 */
public class VolatileDemo {
    public static final Object sync = new Object();
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true) {
            System.out.println(threadDemo.flag); //sout会读取主内存中的值
//            try {
//                Thread.sleep(1);  //线程切换会将线程缓存中的值同步到主内存中
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (threadDemo.flag) {
                System.out.println("主线程读取到的flag = " + threadDemo.flag);
                break;
            }

        }
    }
}

class ThreadDemo implements Runnable {
    public boolean flag = false;
    @Override
    public void run() {
//        try {
//            Thread.sleep(5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + flag);
    }
}
