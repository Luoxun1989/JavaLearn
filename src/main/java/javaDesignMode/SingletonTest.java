package javaDesignMode;

/**
 * “Go Further进无止境” <br>
 * 〈单例模式〉
 * 单例模式，顾名思义就是只有一个实例，并且她自己负责创建自己的对象，这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
 * 核心代码：构造方法私有化，private。
 * 类构造器私有
 * 持有自己类型的属性
 * 对外提供获取实例的静态方法
 *
 *
 *优点：
 *
 * 在内存中只有一个对象，节省内存空间；
 *
 * 避免频繁的创建销毁对象，可以提高性能；
 *
 * 避免对共享资源的多重占用，简化访问；
 *
 * 为整个系统提供一个全局访问点。
 *
 * 缺点：
 *
 *  不适用于变化频繁的对象；
 *
 * 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；
 *
 * 如果实例化的对象长时间不被利用，系统会认为该对象是垃圾而被回收，这可能会导致对象状态的丢失；
 *
 * 适用场景：
 *
 * 1.需要生成唯一序列的环境
 * 2.需要频繁实例化然后销毁的对象。
 * 3.创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
 * 4.方便资源相互通信的环境
 *
 *
 * @author Luoxun
 * @create 2020/4/2
 * @since 1.0.0
 */
public class SingletonTest {

}

/*
 * @Description:懒汉模式  线程不安全，延迟初始化，严格意义上不是单例模式
 * @Date: 2020/4/2 9:30
 * @param:
 * @return:
 **/
class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

/*
 * @Description:饿汉模式  线程安全，比较常用，但容易产生垃圾，因为一开始就初始化
 * @Date: 2020/4/2 10:05
 * @param:
 * @return:
 **/
class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/*
 * @Description: 双重锁模式  线程安全，延迟初始化。这种方式采用双锁机制，安全且在多线程情况下能保持高性能
 * 双重检查模式，进行了两次的判断，第一次是为了避免不要的实例，第二次是为了进行同步，避免多线程问题。由于singleton=new SingletonEnumMode()
 * 对象的创建在JVM中可能会进行重排序，在多线程访问下存在风险，使用volatile修饰signleton实例变量有效，解决该问题。
 * @Date: 2020/4/2 10:08
 * @param:
 * @return:
 **/
class Singleton3 {
    private static volatile Singleton3 instance = null;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {

        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/*
 * @Description: 静态内部类单例模式 只有第一次调用getInstance方法时，虚拟机才加载 Inner 并初始化instance ，只有一个线程可以获得对象的初始化锁，
 * 其他线程无法进行初始化，保证对象的唯一性。目前此方式是所有单例模式中最推荐的模式，但具体还是根据项目选择。
 * @Date: 2020/4/2 10:11
 * @param:
 * @return:
 **/
class Singleton4 {
    private Singleton4() {

    }

    private static class Singleton4Inner {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Singleton4Inner.instance;
    }
}

