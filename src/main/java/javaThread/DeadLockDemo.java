package javaThread;

/**
 * “Go Further进无止境” <br>
 * 〈线程死锁，代码模拟了上图的死锁的〉
 *
 * 形成死锁的四个必要条件是什么
 * 互斥条件：线程(进程)对于所分配到的资源具有排它性，即一个资源只能被一个线程(进程)占用，直到被该线程(进程)释放
 * 请求与保持条件：一个线程(进程)因请求被占用资源而发生阻塞时，对已获得的资源保持不放。
 * 不剥夺条件：线程(进程)已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 循环等待条件：当发生死锁时，所等待的线程(进程)必定会形成一个环路（类似于死循环），造成永久阻塞
 *
 *
 *如何避免线程死锁
 * 我们只要破坏产生死锁的四个条件中的其中一个就可以了。
 *
 * 破坏互斥条件
 *
 * 这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
 *
 * 破坏请求与保持条件
 *
 * 一次性申请所有的资源。
 *
 * 破坏不剥夺条件
 *
 * 占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
 *
 * 破坏循环等待条件
 *
 * 靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。
 *

 * @create 2020/4/16
 * @since 1.0.0
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resource2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + "get resource2");
                    }
                }
            }
        }, "线程 1").start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resource2");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread() + "get resource2");
                    }
                }
            }
        }, "线程 2").start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resource1");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread() + "get resource1");
                    }
                }
            }
        }, "线程 2").start();

    }
}
