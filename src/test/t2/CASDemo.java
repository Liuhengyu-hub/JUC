package test.t2;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    /**
     *
     * @param args
     * 1、CAS是什么 ===> compareAndSet
     *   比较并交换
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data:" + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
