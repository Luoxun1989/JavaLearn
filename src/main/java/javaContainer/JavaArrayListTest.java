package javaContainer; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: javaContainer.JavaArrayListTest
 * Author:   admin
 * Date:     2020/3/25 23:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 数据结构实现：ArrayList 是动态数组的数据结构实现，而 LinkedList 是双向链表的数据结构实现。
 * 随机访问效率：ArrayList 比 LinkedList 在随机访问的时候效率要高，因为 LinkedList 是线性的数据存储方式，所以需要移动指针从前往后依次查找。
 * 增加和删除效率：在非首尾的增加和删除操作，LinkedList 要比 ArrayList 效率要高，因为 ArrayList 增删操作要影响数组内的其他数据的下标。
 * 内存空间占用：LinkedList 比 ArrayList 更占内存，因为 LinkedList 的节点除了存储数据，还存储了两个引用，一个指向前一个元素，一个指向后一个元素。
 * 线程安全：ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；
 *
 * 在需要频繁读取集合中的元素时，更推荐使用 ArrayList，而在插入和删除操作较多时，更推荐使用 LinkedList。
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class JavaArrayListTest {
    public static void main(String[] args) {
        //list to array
        List<String> list2 = new ArrayList<String>();
        list2.add("123");
        list2.add("456");
        String[] rtn = list2.toArray(new String[0]);

        // array to list
        String[] array = new String[]{"123","456"};
        List<String> rtn2 = Arrays.asList(array);
    }
}