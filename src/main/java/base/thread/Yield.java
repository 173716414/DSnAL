package base.thread;

import java.util.concurrent.ExecutionException;

/*
 *Author：Victor_htq
 *Package：base.thread
 *Project：DSnAL
 *name：Yield
 *Date：2024/7/9  15:35
 *Filename：Yield
 */
public class Yield {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(i == 50){
                    Thread.yield();
                }
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2:" + i);
            }
        });
        t2.start();
        t1.start();
    }

}
