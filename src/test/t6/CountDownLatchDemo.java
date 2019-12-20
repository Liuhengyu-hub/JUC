package test.t6;

import test.t5.CountryEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                //countDownLatch减为0时，接触await状态，执行后续代码
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ----------秦帝国，一统华夏");
    }

    public static void clossDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
            //countDownLatch减为0时，接触await状态，执行后续代码
            countDownLatch.countDown();
        }, String.valueOf(i)).start();
    }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ----------班长最后关门走人");
    }
}
