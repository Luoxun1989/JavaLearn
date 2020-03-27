package javaBase; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: javaBase.CollectionsToolTest
 * Author:   admin
 * Date:     2020/3/25 21:16
 * Description: Collections工具类中的sort()方法如何比较元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Collections工具类中的sort()方法如何比较元素〉
 *
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class CollectionsToolTest {
    public static void practice(){
        List list = Arrays.asList("one two three four five six siven".split(" "));
//        Collections.sort(list);
//        Collections.reverse(list);
//        Collections.shuffle(list);
        List n = Arrays.asList("我 是 复制过来的哈".split(" "));
//        Collections.copy(list,n);
//        Collections.fill(list,"yy");
//        System.out.println( Collections.max(list));
        Collections.rotate(list,3);
        System.out.println(list);

    }
    public static void practice2(){
        List<Student> list = new ArrayList<Student>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();    // 比较学生姓名
            }
        });
//        Collections.synchronizedList(list);
        for(Student stu : list) {
            System.out.println(stu);
        }
//      输出结果:
//      javaBase.Student [name=Bob YANG, age=22]
//      javaBase.Student [name=Bruce LEE, age=60]
//      javaBase.Student [name=Hao LUO, age=33]
//      javaBase.Student [name=XJ WANG, age=32]
    }
    public static void main(String[] args) {
        practice();
    }
}