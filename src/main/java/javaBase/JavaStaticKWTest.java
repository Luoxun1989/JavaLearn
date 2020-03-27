package javaBase; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: JavaStaticTest
 * Author:   admin
 * Date:     2020/3/25 20:27
 * Description: static关键字学习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈static关键字学习  该代码在1.8版本报错〉
 *静态代码块在类第一次被载入时执行，在这里主要是想验证一下，类初始化的顺序。
 *
 * 父类静态变量
 *
 * 父类静态代码块
 *
 * 子类静态变量
 *
 * 子类静态代码块
 *
 * 父类普通变量
 *
 * 父类普通代码块
 *
 * 父类构造函数
 *
 * 子类普通变量
 *
 * 子类普通代码块
 *
 * 子类构造函数
 *
 * 代码验证一下：
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class JavaStaticKWTest {
    Person person = new Person("Test");

    public JavaStaticKWTest() {
        System.out.println("test constructor");
    }

    /* 静态代码块和静态方法的区别
   两者的区别就是:静态代码块是自动执行的;静态方法是被调用的时候才执行的 静态代码块只在第一次new执行一次，之后不再执行
     **/
    static{
        System.out.println("test static");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends JavaStaticKWTest {
    Person person = new Person("javaBase.MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}
