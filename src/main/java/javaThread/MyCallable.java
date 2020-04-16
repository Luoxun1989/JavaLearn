package javaThread;

import java.util.concurrent.Callable;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 * 创建实现Callable接口的类myCallable
 * 以myCallable为参数创建FutureTask对象
 * 将FutureTask作为参数创建Thread对象
 * 调用线程对象的start()方法
 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
        return 1;
    }
}
