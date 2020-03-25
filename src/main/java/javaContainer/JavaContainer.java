package javaContainer;

import java.util.*;

/**
 * “Go Further进无止境” <br>
 * 〈Java 容器基础知识〉
 *
 * @author Luoxun
 * @create 2020/3/24
 * @since 1.0.0
 */
public class JavaContainer {
    public static void main(String[] args) {
       /* // list to array
        List<String> list = new ArrayList<String>();
        list.add("叶痕秋");
        list.add("的诗情画意");
        list.toArray();
        // array to list
        String[] array = new String[]{"王磊", "的诗情画意"};
        Arrays.asList(array);

        Queue<String> queue = new LinkedList<String>();
        queue.offer("string"); // add
        System.out.println(queue.poll());
//        System. out. println(queue. remove());
        System.out.println(queue.size());

        List<String> list2 = new ArrayList<String>();
        list.add("x");
        Collection<String> clist = Collections.unmodifiableCollection(list);
        clist.add("y"); // 运行时此行报错
        System.out.println(list.size());*/

       /* ArrayList nums = new ArrayList();
        nums.add(8);
        nums.add(-3);
        nums.add(2);
        nums.add(9);
        nums.add(-2);

        System.out.println("集合是否为空：" + nums.isEmpty());

        System.out.println("默认顺序：" + nums);
        Collections.reverse(nums);
        System.out.println("反转后顺序：" + nums);

        Collections.sort(nums);
        System.out.println("排序后顺序：" + nums);

        Collections.shuffle(nums);
        System.out.println("混淆后顺序：" + nums);
        // 下面只是为了演示定制排序的用法，将int类型转成string进行比较
        Collections.sort(nums, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return s1.compareTo(s2);
            }

        });
        System.out.println("指定排序后顺序：" + nums);
        System.out.println("最大的值是：" + Collections.max(nums));
        System.out.println("最小的值是：" + Collections.min(nums));
        hashMapTest();*/


    }
    private static void arrayListTest(){

    }

    static class Ctime {
        int count = 1;

        public String toString() {
            return Integer.toString(count);
        }
    }
    private static void hashMapTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "ddd");
        map.put("b", "bbb");
        map.put("a", "aaa");
        map.put("c", "ccc");
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

        HashMap h1 = new HashMap();
        Random r1 = new Random();
        for (int i = 0; i < 1000; i++) {
            Integer t = new Integer(r1.nextInt(20));
            if (h1.containsKey(t))
                ((Ctime) h1.get(t)).count++;
            else
                h1.put(t, new Ctime());
        }
        System.out.println(h1);
        System.out.println(h1.keySet());
    }
}


