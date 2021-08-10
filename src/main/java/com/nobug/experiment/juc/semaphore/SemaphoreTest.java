package com.nobug.experiment.juc.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        Semaphore semaphore = new Semaphore(2, false);
        new Thread(semaphoreTest.new AThread(semaphore), "AThread").start();
        new Thread(semaphoreTest.new BThread(semaphore), "BThread").start();
    }
    class AThread implements Runnable {
        private Semaphore semaphore;
        private AThread (Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public AThread initAThreadBySemaphore (Semaphore semaphore) {
            return new AThread(semaphore);
        }
        @Override
        public void run() {
            try {
                acquireSemaphore();

                printZeroToTen();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                releaseSemaphore();
            }
        }

        public void acquireSemaphore () throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + "尝试获取权限中...");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "获取权限成功...");
        }

        public void printZeroToTen () throws InterruptedException {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" +i);
                Thread.sleep(10);
            }
        }
        public void releaseSemaphore () {
            semaphore.release();
        }
    }

    class BThread implements Runnable {
        private Semaphore semaphore;
        private BThread (Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public BThread initBThreadBySemaphore (Semaphore semaphore) {
            return new BThread(semaphore);
        }
        @Override
        public void run() {
            try {
                acquireSemaphore();

                printZeroToTen();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                releaseSemaphore();
            }
        }
        public void acquireSemaphore () throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + "尝试获取权限中");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "获取权限成功");
        }

        public void printZeroToTen () throws InterruptedException {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" +i);
                Thread.sleep(10);
            }
        }
        public void releaseSemaphore () {
            semaphore.release();
        }
    }
}
