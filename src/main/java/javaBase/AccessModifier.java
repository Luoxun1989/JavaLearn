/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AccessModifier
 * Author:   admin
 * Date:     2020/3/26 23:39
 * Description: 访问修饰符
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package javaBase;

/**
 * 〈一句话功能简述〉<br> 
 * 〈访问修饰符〉
 *
 * @author admin
 * @create 2020/3/26
 * @since 1.0.0
 */
public class AccessModifier {
    protected String s = "kkk";
    float ff = 0.9F;
    public boolean isHe = false;

    public AccessModifier(){
        System.out.println("load AccessModifier.class");
    }
    private void privateMethod(){
        System.out.println("private");
    }
    protected void protectedMethod(){
        System.out.println("protected");
    }
}
class AccessModifierSub2 extends AccessModifier {
    public static void main(String[] args) {
        System.out.println(new AccessModifier().ff);
        System.out.println(new AccessModifier().s);
        System.out.println(new AccessModifier().isHe);
        new AccessModifier().protectedMethod();
    }
}