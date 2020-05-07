package JavaEffective;

import java.util.Random;

/**
 * “Go Further进无止境” <br>
 * 〈优先 选择 基本 类型〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client29 {
    public static void main(String[] args) {
        int i=150;
        f(i);
        f(Integer.valueOf(i));
        //
        Random random = new Random();
        for (int j = 0; j < 4; j++) {
            System.out.println(random.nextInt());
        }
    }
    private static  void f(long i){
        System.out.println("基本类型的方法");
    }
    private static void f(Long i){
        System.out.println("包装类型的方法");
    }
}
