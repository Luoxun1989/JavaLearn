package javaContainer;

import java.util.*;

/**
 * “Go Further进无止境” <br>
 * 〈迭代器 Iterator〉
 *Iterator 接口提供遍历任何 Collection 的接口。我们可以从一个 Collection 中使用迭代器方法来获取迭代器实例。
 * 迭代器取代了 Java 集合框架中的 Enumeration，迭代器允许调用者在迭代过程中移除元素。
 *
 * 最佳实践：Java Collections 框架中提供了一个 RandomAccess 接口，用来标记 List 实现是否支持 Random Access
 * 支持 Random Access 的列表可用 for 循环遍历，否则建议用 Iterator 或 foreach 遍历
 * 意思是可以对传过来的list参数进行判断
 *
 * @author Luoxun
 * @create 2020/4/2
 * @since 1.0.0
 */
public class JavaIteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(0);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Iterator<String> iterator = list.iterator();
        while(iterator. hasNext()){
            String obj = iterator. next();
            System. out. println(obj);
            iterator.remove();
        }
        for (String i : list){
            System. out. println(i);
        }


    }

    private void RandomAccessTest(List list){
        if (list instanceof RandomAccess){
            //支持 Random Access 的列表可用 for 循环遍历  位置读取元素的平均时间复杂度为 O(1)
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }else{
            for (Iterator iter = list.iterator();iter.hasNext();) {
                System.out.println(iter.next());
            }
        }
    }
}
