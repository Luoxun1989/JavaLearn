package JavaEffective;

/**
 * “Go Further进无止境” <br>
 * 〈判断， 对于 Integer 包装 类型， 是 根据 其 intValue（） 方法 的 返回 值（ 也就是 其 相应 的 基本 类型） 进行 比较 的
 * （ 其他 包装 类型 是 根据 相应 的 value 值 来 比较 的， 如 doubleValue、 floatValue 等）， 那 很 显然， 两者 不可 能有 大小 关系 的。
 * 问题 清楚 了， 修改 总是 比较 容易 的， 直接 使用 Integer 实例 的 compareTo
 *
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client27 {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        compare(i, j);
    }

    //比较 两个 包装 对象 大小
    public static void compare(Integer i, Integer j) {
        System.out.println(i.intValue() == j.intValue());
        System.out.println(i.compareTo(j));
        System.out.println(i < j);
    }

}
