package javaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/20
 * @since 1.0.0
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //表示10个学生
/*        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(new MyRunnable());
        }
        service.shutdown();*/

        //模拟10辆车去停车，只有5个车位，需要同步
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyRunnable(), "[Car-" + (i + 1) + "]");
            thread.start();
        }
    }
}
