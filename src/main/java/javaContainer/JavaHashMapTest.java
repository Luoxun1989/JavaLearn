package javaContainer; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: javaContainer.JavaHashMapTest
 * Author:   admin
 * Date:     2020/3/25 21:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2020/3/25
 * @since 1.0.0
 */
public class JavaHashMapTest {
    private static void s1() {
        Map<Object, Object> hashMap = new HashMap<Object, Object>(0);
        Map<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(0);
        Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>(0);
        Map<Object, Object> treeMap = new TreeMap<Object, Object>();
        hashMap.put(null, "3");
        hashMap.put("aa", "1");
        hashMap.put("ee", "6");
        hashMap.put("gg", "7");
        hashMap.put("bb", "34");

        linkedHashMap.put("aa", "1");
        linkedHashMap.put("cc", "3");
        linkedHashMap.put("ee", "6");
        linkedHashMap.put("bb", "34");
        linkedHashMap.put("gg", "7");

        hashtable.put("aa", "1");
        hashtable.put("cc", "3");
        hashtable.put("kk", "6");
        hashtable.put("bb", "34");
        hashtable.put("gg", "7");

        treeMap.put("aa", "1");
        treeMap.put("cc", "3");
        treeMap.put("ee", "6");
        treeMap.put("bb", "34");
        treeMap.put("gg", "7");

        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry obj = iterator.next();
            System.out.println(obj.getKey() + "---" + obj.getValue());
        }

        System.out.println("\n");
        Iterator<Map.Entry<Object, Object>> iterator2 = linkedHashMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry obj = iterator2.next();
            System.out.println(obj.getKey() + "---" + obj.getValue());
        }
        System.out.println("\n");
        Iterator<Map.Entry<Object, Object>> iterator3 = hashtable.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry obj = iterator3.next();
            System.out.println(obj.getKey() + "---" + obj.getValue());
        }
        System.out.println("\n");
        Iterator<Map.Entry<Object, Object>> iterator4 = treeMap.entrySet().iterator();
        while (iterator4.hasNext()) {
            Map.Entry obj = iterator4.next();
            System.out.println(obj.getKey() + "---" + obj.getValue());
        }
    }

    public static void main(String[] args) {
        s2();

    }

    private static  void s2() {
        //10万个数据统计数据重复出现的次数并打印
        //首先随机产生10万个原始数据
        LinkedList list = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(100));
        }
        //统计出现的次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            Integer num = map.get(value);
            if (num == null) {
                map.put(value, 1);
            } else {
                map.put(value, num + 1);
            }
        }
        //打印数据
        System.out.println("统计10万个数据重复出现的次数："+map.size());
        Iterator<Map.Entry<Integer, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator1.next();
            Integer value1 = entry.getKey();
            Integer number = entry.getValue();
            System.out.print(number + "  " + value1 + "      ");
        }
        System.out.println();
    }
}