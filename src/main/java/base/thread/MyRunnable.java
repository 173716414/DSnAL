package base.thread;

// 实现Runnable接口来创建一个线程任务
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 这里放置线程执行的代码
        System.out.println("通过实现Runnable接口来运行线程");
    }
}