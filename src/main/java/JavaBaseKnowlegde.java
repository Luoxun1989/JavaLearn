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
    }
}
