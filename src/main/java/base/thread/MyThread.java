package base.thread;

// 继承Thread类来创建一个新的线程类
public class MyThread extends Thread {
    @Override
    public void run() {
        // 这里放置线程执行的代码
        System.out.println("通过继承Thread类来运行线程");
    }
}

