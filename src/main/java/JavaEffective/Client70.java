package JavaEffective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/23
 * @since 1.0.0
 */
public class Client70 {
    public static void main(String[] args) {
        //定义一个包含两个字符串的列表
        List<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        //构造一个包含c的字符串列表
        List<String> c1 = new ArrayList<String>(c);
        //通过subList生成与c相同的列表
        List<String> c2 = c.subList(0, c.size());
        //c2增加一个元素
        c2.add("C");
        System.out.println("c == c1? " + c.equals(c1));
        System.out.println("c == c2? " + c.equals(c2));


        List<Integer> initData = Collections.nCopies(100,0);
        ArrayList<Integer> list = new ArrayList<Integer>(initData);
        list.subList(20,30).clear();
        System.out.println(list.size());


        //我们 的 List 也可以 有多 个 视图， 也就是 可以 有多 个子 列表， 但 问题是 只要 生成 的 子 列表 多于 一个， 则 任何 一个 子
        // 列表 就都 不能 修改 了， 否则 就会 抛出 ConcurrentModificationException 异常。
        List<String> ct = new ArrayList<String>();
        ct.add("A");
        ct.add("B");
        ct.add("C");
        ct.add("V");
        List<String> subList1 = ct.subList(0,2);
//        ct.add("G");  //错误 ，不可以再修改原始列表
        List<String> subList3 = ct.subList(0,3);
        System.out.println(subList1.size());
//        subList1.add("G");  //错误 ，不可以再修改子列表
        System.out.println(subList3.size());

    }

}
