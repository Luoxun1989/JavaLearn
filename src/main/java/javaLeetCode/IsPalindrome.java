package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈9. 回文数〉
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author Luoxun
 * @create 2020/3/26
 * @since 1.0.0
 */
public class IsPalindrome {
    public static  boolean isPalindrome(int x) {
        return (x + "").equals((new StringBuilder(x + "")).reverse().toString());
    }
    public static  boolean isPalindrome2(int x) {
        if(x < 0) return false;
        if(x / 10 < 1) return true;
        int re = 0;
        int num = x;
        while (x != 0){
            int a = x % 10;
            re = re * 10 + a;
            x = x / 10;
        }
        return num == re;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
    }
}
