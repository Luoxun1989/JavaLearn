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
 *
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class JavaStaticKWTest {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public JavaStaticKWTest() {
        System.out.println("test constructor");
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
