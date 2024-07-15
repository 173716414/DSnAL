package base.thread;

import java.util.concurrent.ExecutionException;

/*
 *Author：Victor_htq
 *Package：base.thread
 *Project：DSnAL
 *name：Priority
 *Date：2024/7/9  15:33
 *Filename：Priority
 */
public class Priority {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t2:" + i);
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t2.start();
        t1.start();
    }

}
