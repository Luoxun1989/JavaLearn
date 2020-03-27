package javaLeetCode;

/**
 * “Go Further进无止境” <br>
 * 〈编写一个函数来查找字符串数组中的最长公共前缀。〉
 *
 * @author Luoxun
 * @create 2020/3/27
 * @since 1.0.0
 */
public class LongestCommonPrefix {
    //暴力破解
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
//        if (strs.length == 1) return strs[0];
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min){
                min = strs[i].length();
                index = i;
            }
        }
        for (int i = 0; i < strs[index].length(); i++) {
            boolean b = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) == strs[index].charAt(i)){
                    b = true;
                }else{
                    b = false;
                    break;
                }

            }
            if (!b){
                return strs[index].substring(0,i);
            }
        }
        return strs[index];
    }
    //水平横扫
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    //分治法
    public static String longestCommonPrefix3(String[] strs) {
        return "";
    }
    //二分查找法
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs){
            minLen = Math.min(str.length(),minLen);
        }
        int low = 1;
        int high = minLen;
        while (low <= high){
            int middle = (low + high) /2 ;
            if (isCommonPrefix(strs, middle)){
                low = middle + 1;
            }else {
                high = middle -1;
            }
        }
        return strs[0].substring(0,(low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs,int len){
        String str = strs[0].substring(0,len);
        for (int i = 0; i < strs.length; i++) {
            if(!strs[i].startsWith(str)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"a"}));
    }
}
