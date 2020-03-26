/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AccessModifierSub
 * Author:   admin
 * Date:     2020/3/26 23:40
 * Description: 访问修饰符子类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package javaBase;

/**
 * 〈一句话功能简述〉<br> 
 * 〈访问修饰符子类〉
 *
 * @author admin
 * @create 2020/3/26
 * @since 1.0.0
 */
public class AccessModifierSub extends AccessModifier{
    public static void main(String[] args) {
        System.out.println(new AccessModifier().ff);
        System.out.println(new AccessModifier().s);
        System.out.println(new AccessModifier().isHe);
        new AccessModifier().protectedMethod();
    }
}