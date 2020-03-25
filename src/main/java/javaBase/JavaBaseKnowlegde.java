package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈java基础知识点1〉
 *
 * @author Luoxun
 * @create 2020/3/24
 * @since 1.0.0
 */
public class JavaBaseKnowlegde {
    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y); // true
        System.out.println(x==z); // false
        System.out.println(x.equals(y)); // true
        System.out.println(x.equals(z)); // true

        Integer a = new Integer(3);
        Integer b = 3; // 将 3 自动装箱成 Integer 类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一象
        System.out.println(a == c); // true a 自动拆箱成 int 类型再和 c比较
        System.out.println(b == c);

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}
