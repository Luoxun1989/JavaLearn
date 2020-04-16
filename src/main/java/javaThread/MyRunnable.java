package javaThread;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 * 定义Runnable接口实现类MyRunnable，并重写run()方法
 * 创建MyRunnable实例myRunnable，以myRunnable作为target创建Thead对象，该Thread对象才是真正的线程对象
 * 调用线程对象的start()方法
 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run()方法执行中...");
    }
}
