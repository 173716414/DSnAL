package base.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExample {

    public static void main(String[] args) {
        // 创建一个timer实例
        Timer timer = new Timer();

        // 创建一个TimerTask实例
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                // 调用你想要每五分钟执行一次的方法
                myMethod();
            }
        };

        // 设定任务的调度，立即开始，每五分钟执行一次（300000毫秒）
        timer.scheduleAtFixedRate(repeatedTask, 0, 100000);
    }

    // 这是要定期执行的方法
    public static void myMethod() {
        System.out.println("方法被调用 - " + System.currentTimeMillis() / 1000);
    }
}
