package javaBase;
/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: javaBase.Student
 * Author:   admin
 * Date:     2020/3/25 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class Student {
    private String name;    // 姓名
    private int age;        // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取学生年龄
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "javaBase.Student [name=" + name + ", age=" + age + "]";
    }

}