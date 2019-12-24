package test.t7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //抛出异常
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.remove("a"));
        //特殊值
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.poll());
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.take();
        //超时退出
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));


    }
    }


