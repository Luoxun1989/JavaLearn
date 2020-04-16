package javaThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * “Go Further进无止境” <br>
 * 〈线程创建测试〉
 *创建线程有四种方式：
 *
 * 继承 Thread 类；
 * 实现 Runnable 接口；
 * 实现 Callable 接口；
 * 使用 Executors 工具类创建线程池
 *
 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class BulidThreadTest {
    public static void main(String[] args) {
        //..................................................................................
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName() + " main() myThread方法执行结束");
        //..................................................................................

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println(Thread.currentThread().getName() + " main() myRunnable法执行结束");
        //..................................................................................

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        try {
            Thread.sleep(1000);
            System.out.println("返回结果 " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " main() MyCallable方法执行完成");
        //..................................................................................


    }
}
