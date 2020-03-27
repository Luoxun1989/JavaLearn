package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈java基础知识点1〉
 *
 * @author Luoxun
 * @create 2020/3/24
 * @since 1.0.0
 */
public class JavaStringBase {
    public static void main(String[] args) {
        practice3();
    }
    public static void  practice1(){
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y); // true
        System.out.println(x==z); // false
        System.out.println(x.equals(y)); // true
        System.out.println(x.equals(z)); // true
    }
    public static void  practice2(){
        Integer a = new Integer(3);
        Integer b = 3; // 将 3 自动装箱成 Integer 类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一象
        System.out.println(a == c); // true a 自动拆箱成 int 类型再和 c比较
        System.out.println(b == c);
    }
    public static void  practice3(){

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        Integer f6 = -129, f7 = -129, f8 = 127, f9 = 127;
        System.out.println(f1 == f2);
        //false Integer常量池大小 -128-127，超过了分配到堆内存
        System.out.println(f3 == f4);
        System.out.println(f6 == f7);
        System.out.println(f8 == f9);
    }
    public static void  practice4(){
        short s1 = 1; s1 += 1; // 正确 隐含了强制转换
//        short s1 = 1; s1 = s1 + 1; // 有错 1是int，需要强制转换
    }
}
