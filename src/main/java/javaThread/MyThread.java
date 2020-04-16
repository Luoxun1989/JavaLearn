package javaThread;

/**
 * “Go Further进无止境” <br>
 *1 定义一个Thread类的子类，重写run方法，将相关逻辑实现，run()方法就是线程要执行的业务逻辑方法
 *2 创建自定义的线程子类对象
 *3 调用子类实例的star()方法来启动线程
 *
 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run()方法正在执行...");
    }
}
