package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈整数反转 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。〉
 *假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author Luoxun
 * @create 2020/3/26
 * @since 1.0.0
 */
public class IntegerReverse {
    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int a = num % 10;
            num = num / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && a > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && a < -8)) {
                return 0;
            }
            rev = rev * 10 + a;
        }
        return rev;
    }
}
