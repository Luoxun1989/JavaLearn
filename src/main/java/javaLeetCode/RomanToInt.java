package javaLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * “Go Further进无止境” <br>
 * 〈罗马数字转整数〉
 *
 * @author Luoxun
 * @create 2020/3/26
 * @since 1.0.0
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int preNum = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int curNum = getValue(s.charAt(i));
            if (preNum < curNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = curNum;
        }
        sum += preNum;
        return sum;
    }

    public static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);


        int sum = 0;
        int j = 0;
        for (int i = 0; i < s.length()-1; ) {
            String key = s.substring(i, i + 2);
            if (map.containsKey(key)) {
                sum += map.get(key);
                i += 2;
                j = i;
            } else {
                key = s.substring(i, i + 1);
                if (map.containsKey(key)) {
                    sum += map.get(key);
                    i += 1;
                    j = i;
                }
            }

        }
        if (j == s.length() - 1) {
            sum += map.get(s.substring(s.length() - 1));
        }
        return sum;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("MDCCMMMXXCCCCIV"));
        System.out.println(romanToInt("MDCCMMMXXCCCCIV"));
    }
}
