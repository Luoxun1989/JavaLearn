package javaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *Executors提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
 *
 * 主要有newFixedThreadPool，newCachedThreadPool，newSingleThreadExecutor，newScheduledThreadPool，后续详细介绍这四种线程池

 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class MySingleThreadExecutor {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnableTest = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnableTest);
        }

        System.out.println("线程任务开始执行,");
        executorService.shutdown();
    }
}
