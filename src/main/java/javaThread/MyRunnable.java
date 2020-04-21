package javaThread;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 * 定义Runnable接口实现类MyRunnable，并重写run()方法
 * 创建MyRunnable实例myRunnable，以myRunnable作为target创建Thead对象，该Thread对象才是真正的线程对象
 * 调用线程对象的start()方法
 *
 * @author Luoxun
 * @create 2020/4/16
 * @since 1.0.0
 */
public class MyRunnable implements Runnable {
    private static Semaphore semaphore = new Semaphore(5);
    private String command;
    public MyRunnable(String s){
        this.command = s ;
    }
    public MyRunnable(){
    }
    //@Override
    public void run2() {

      /*  try {
            System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "  同学获取到笔");
            System.out.println(Thread.currentThread().getName() + "  填写表格ing.....");
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！！！！！！");
        }*/

        try {
            //1.开始停车，先获取许可(相当于获取一个车位)
            semaphore.acquire();
            //2.模拟停车3秒钟
            System.out.println(Thread.currentThread().getName() + " 开始准备停车,剩余车位是: " +
                    semaphore.availablePermits() + " -- " + new Date());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //3.停车完毕释放(归还许可，相当于释放车位)
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " 线程停车完毕,剩余车位是: " +
                    semaphore.availablePermits() + " -- " + new Date());
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
            System.out.println("this.command: "+this.command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return this.command;
    }

}
