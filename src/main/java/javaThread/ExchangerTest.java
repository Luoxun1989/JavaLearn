package javaThread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * “Go Further进无止境” <br>
 * 〈Exchanger是一个用于线程间协作的工具类，用于两个线程间交换数据。它提供了一个交换的同步点，在这个同步点两个线程能够交换数据。
 * 交换数据是通过exchange方法来实现的，如果一个线程先执行exchange方法，那么它会同步等待另一个线程也执行exchange方法，这个时候
 * 两个线程就都达到了同步点，两个线程就可以交换数据。
 * @author Luoxun
 * @create 2020/4/20
 * @since 1.0.0
 */
public class ExchangerTest {
    private static Exchanger<String> exchanger = new Exchanger();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //男生对女生说的话
                    String girl = exchanger.exchange("我其实暗恋你很久了......");
                    System.out.println("女孩儿说：" + girl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("女生慢慢的从教室你走出来......");
                    TimeUnit.SECONDS.sleep(3);
                    //男生对女生说的话
                    String boy = exchanger.exchange("我也很喜欢你......");
                    System.out.println("男孩儿说：" + boy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
