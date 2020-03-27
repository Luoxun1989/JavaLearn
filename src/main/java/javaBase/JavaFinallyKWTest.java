package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈finally知识点〉
 *
 * @author Luoxun
 * @create 2020/3/27
 * @since 1.0.0
 */
public class JavaFinallyKWTest {
    //如果程序是从try代码块或者catch代码块中返回时，finally中的代码总会执行。
    public static int show() {

        try {
            return 1;
        }finally{
            System.out.println("finally模块被执行");
        }
    }
    //优先执行catch中的return
    public static int show2() {
        try {
            int a = 8/0;
            return 1;
        }catch (Exception e) {
            return 2;
        }finally{
            System.out.println("finally模块被执行");

        }
    }
    //优先执行finally中的return
    public static int show3() {
        try {
            int a = 8/0;
            return 1;
        }catch (Exception e) {
            return 2;
        }finally{
            System.out.println("finally模块被执行");
            return 3;
        }
    }

    //finally中对于返回变量做的改变不会影响最终的返回结果  依旧返回0
    public static int show4() {
        int result = 0;
        try {
            return result;
        }finally{
            System.out.println("finally模块被执行");
            result = 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(show());
        System.out.println(show2());
        System.out.println(show3());
        System.out.println(show4());
    }
}
