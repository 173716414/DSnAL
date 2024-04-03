package base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 实现Callable接口，这允许线程返回一个值
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 这里放置线程执行的代码
        return "通过实现Callable接口来运行线程";
    }
}
