package JavaEffective;

import java.util.Date;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client18 {

    public static void main(String[] args) {
        //String 对象 是否 是 Object 的 实例
        boolean b1 = "Sting" instanceof Object;
        // String 对象 是否 是 String 的 实例
        boolean b2 = new String() instanceof String;
        // Object 对象 是否 是 String 的 实例
        boolean b3 = new Object() instanceof String;
        // 拆 箱 类型 是否 是 装箱 类型 的 实例
//        boolean b4 = 'A' instanceof Character;   编译不通过，instanceof只能用于对象的判断，不能用于基本类型的判断
        // 空对 象 是否 是 String 的 实例
        boolean b5 = null instanceof String;
        // 类型 转换 后的 空对 象 是否 是 String 的 实例
        boolean b6 = (String) null instanceof String;
        // Date 对象 是否 是 String 的 实例
//        boolean b7 = new Date() instanceof String; 编译不通过，两者没有继承或实现关系
        // 在 泛 型 类 中 判断 String 对象 是否 是 Date 的 实例
        boolean b8 = new GenericClass<String>().isDateInstance("");
    }
}

class GenericClass<T> {
    //判断 是否 是 Date 类型
    public boolean isDateInstance(T t) {
        return t instanceof Date;
    }
}


