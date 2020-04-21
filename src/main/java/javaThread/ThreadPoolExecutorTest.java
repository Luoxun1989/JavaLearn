package javaThread;

import java.util.concurrent.*;

/**
 * “Go Further进无止境” <br>
 * 〈《阿里巴巴Java开发手册》中强制线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，
 * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险〉
 * newFixedThreadPool 和 newSingleThreadExecutor:
 * 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。
 * newCachedThreadPool 和 newScheduledThreadPool:
 * 主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM。
 *
 * @author Luoxun
 * @create 2020/4/20
 * @since 1.0.0
 */
public class ThreadPoolExecutorTest {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 30;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 50; i++) {
            MyRunnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
