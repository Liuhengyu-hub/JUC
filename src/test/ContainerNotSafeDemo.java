package test;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * ArrayList
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {

    }

    public static void mapNotSafe() {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {

            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
            new HashSet<>();
        }
    }

    public static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {

            new Thread(() -> {
            set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(i)).start();
            new HashSet<>();
        }
    }

    public static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {

            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
        //   JUC        并发       修改       异常

        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         *
         * 2 导致原因
         *      并发争抢修改导致，参考花名册签名情况
         *      一个人正在写入，另一个同学过来争抢，导致数据不一致异常-->并发修改异常
         * 3 解决方案
         *      3.1 new vector()
         *      3.2 Collections.synchronizedList(new ArrayList<>())
         *      3.3 new CopyOnWriteArrayList<>();  (写时复制)
         * 4 优化建议（同样的错误不犯第二次）
         *      写时复制
         *      CopyOnWrite容器即写时复制容器，往一个容器添加元素的时候，不直接向当前容器object[]添加，而是先将当前容器object[]进行copy，
         *      复制出一个新的容器object[] newElements,然后向新的容器object[] newElements中添加元素，添加完元素后，
         *      再将原容器的引用指向新的容器setArray(newElements); 。这样做的好处是可以对CopyOnWrite容器进行并发的读，
         *      而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
         *
         */}
}
