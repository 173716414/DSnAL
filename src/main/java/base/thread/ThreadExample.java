package base.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建MyCallable类的实例
        MyCallable myCallable = new MyCallable();
        // 使用FutureTask来包装MyCallable对象
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        // 创建Thread类的实例并传入futureTask作为线程任务
        Thread thread = new Thread(futureTask);
        // 调用start方法启动线程
        thread.start();
        // 获取线程执行结束后的返回值
        String result = futureTask.get();
        System.out.println(result);
    }
}