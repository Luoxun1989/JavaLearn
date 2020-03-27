package javaLeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * “Go Further进无止境” <br>
 * 〈20. 有效的括号〉
 *
 * @author Luoxun
 * @create 2020/3/27
 * @since 1.0.0
 */
public class IsValidBracket {
    public static boolean isValid(String s) {

        if (null == s || s.length() % 2 != 0){
            return false;
        }
        if (s.length() < 1){
            return true;
        }
        HashMap<Character, Character> mappings = new HashMap<Character, Character>(0);
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');

        Stack<Character> stack = new Stack<Character>();

        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(stack.empty()){
                stack.push(s.charAt(i));
            }else{
                char a = stack.pop();
                if (mappings.containsKey(a)){
                    if (mappings.get(a) == s.charAt(i)){

                    }else{
                        stack.push(a);
                        stack.push(s.charAt(i));
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[](([])){}"));
        System.out.println(isValid("{[{})}"));
    }
}
