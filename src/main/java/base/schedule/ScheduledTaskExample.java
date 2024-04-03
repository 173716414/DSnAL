package base.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExample {

    public static void main(String[] args) {
        // 创建一个单线程的ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 定义要执行的任务
        Runnable task = new Runnable() {
            public void run() {
                // 调用你想要每五分钟执行一次的方法
                myMethod();
            }
        };

        // 使用scheduler以固定延迟时间5分钟调度任务
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

    // 这是要定期执行的方法
    public static void myMethod() {
        System.out.println("方法被调用 - " + System.currentTimeMillis() / 1000);
    }
}
