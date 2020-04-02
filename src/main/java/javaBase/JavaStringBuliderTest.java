package javaBase;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/3/31
 * @since 1.0.0
 */
public class JavaStringBuliderTest {
    public static Pattern pattern1 = Pattern.compile("@\\$@\\$@");
    public static Pattern pattern2 = Pattern.compile("&\\$&");
    public static Set<String> keyhasmatched = new TreeSet<String>();
    public static void main(String[] args) {
        /*String string = "100001|346542768@$@$@1016374277|100003|狩魔手记|烟雨江南|7952975|1|1|1&$&1016374277|100003|狩魔手记|" +
                "烟雨江南|7947826|1|1|1&$&1000357433|100001|狩魔手记|邱晓华;烟雨江南|346542768|0|1|2&$&1016374277|100003|狩魔手记|" +
                "烟雨江南|7944407|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|7786706|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|" +
                "7689139|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|7401960|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|7401957" +
                "|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|7039804|1|1|1" +
                "&$&1016374277|100003|狩魔手记|烟雨江南|6974298|1|1|1&$&1016374277|100003|狩魔手记|烟雨江南|8012868|1|1|1";
//        String[] ss = splitStr(string,"&$&");
        String[] ss = splitStr2(string);
        for (String s : ss){
            System.out.println(s);
        }*/
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();

        Set<String> temp = new HashSet<String>();
        String[] ts = new String[]{"C", "B", "D"};
        Collections.addAll(temp, ts);
        map.put("B", temp);


        Set<String> temp2 = new HashSet<String>();
        String[] ts2 = new String[]{"E", "G"};
        Collections.addAll(temp2, ts2);
        map.put("A", temp2);


        Set<String> temp3 = new HashSet<String>();
        String[] ts3 = new String[]{"T", "S"};
        Collections.addAll(temp3, ts3);
        map.put("C", temp3);


        Set<String> temp4 = new HashSet<String>();
        String[] ts4 = new String[]{"F"};
        Collections.addAll(temp4, ts4);
        map.put("D", temp4);

        Map<String, Set<String>> allSidbidBooksMap = new HashMap<String, Set<String>>();
        Iterator<Map.Entry<String, Set<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Set<String>> entry = iterator.next();
            Set<String> temp5 = allSidbidBooksMap.get(entry.getKey());
            if (temp5 == null) {
                temp5 = new HashSet<String>();
            }
            temp5.addAll(entry.getValue());
            for (String iKey : entry.getValue()) {
                System.out.println(entry.getKey()+"..."+iKey);
                if (entry.getKey().equals(iKey)) {
                    continue;
                } else {
                    Set<String> st = map.get(iKey);
                    if (null != st) {
                        temp5.addAll(st);
                    }
                }
                temp5.addAll(entry.getValue());
            }
            allSidbidBooksMap.put(entry.getKey(), temp5);
        }
        Iterator<Map.Entry<String, Set<String>>> iterator2 = allSidbidBooksMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Set<String>> entry2 = iterator2.next();
            System.out.println("key= " + entry2.getKey());
            System.out.println("value= " + entry2.getValue().toString());
        }
        mergeIncrementBook(allSidbidBooksMap);
    }

    public static String[] splitStr1(String source) {
        return pattern1.split(source);
    }

    public static String[] splitStr2(String source) {
        return pattern2.split(source);
    }
    private static void mergeIncrementBook(Map<String, Set<String>> similarBooks) {
        Set<Set<String>> rlt = new HashSet<Set<String>>();
        Map<String, Integer> rltSizeMap = new TreeMap<String, Integer>();
        for(String key : similarBooks.keySet()){
            rltSizeMap.put(key, similarBooks.get(key).size());
        }
        List<Map.Entry<String, Integer>> rltSizeList = new ArrayList<Map.Entry<String, Integer>>(rltSizeMap.entrySet());
        Collections.sort(rltSizeList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        for (Map.Entry<String, Integer> mapping : rltSizeList) {
            if(keyhasmatched.contains(mapping.getKey())){
                continue;
            }else{
                keyhasmatched.add(mapping.getKey());
            }
            Set<String> bookstring = findSimilarBook(similarBooks, similarBooks.get(mapping.getKey()));
            bookstring.add(mapping.getKey());
//            System.out.println(mapping.getKey()+"=="+bookstring.toString());
            rlt.add(bookstring);
        }
        rlt.clear();
        rltSizeMap.clear();
        similarBooks.clear();
    }

    private static Set<String> findSimilarBook(Map<String, Set<String>> similarBooks, Set<String> books) {
        Set<String> rlt = new TreeSet<String>();
        int count = 0;
        while (count < 5) {
            for (String bk : books) {
                rlt.add(bk);
                keyhasmatched.add(bk);
                if (similarBooks.get(bk) != null) {
                    rlt.addAll(similarBooks.get(bk));
                }
            }
            if (equal(books,rlt)) {
                return rlt;
            }
            books.clear();
            books.addAll(rlt);
            count++;
        }
        return rlt;
    }

    private static  boolean equal(Set<String> a,Set<String> b){
        if (null == b || null == a) {
            return false;
        }
        if (a.size() != b.size()){
            return false;
        }
        String[] as = a.toArray(new String[0]);
        String[] bs = b.toArray(new String[0]);
        for (int i = 0; i < as.length; i++) {
            if (!as[i].equals(bs[i])){
                return false;
            }
        }
        return true;
    }

    private void reprocessIncrementBook(List<String> lines) {
        //siteid+bookid为key, 若干本书集合为value
        Map<String, Set<String>> sidbidBooksMap = new HashMap<String, Set<String>>(0);
        //autoid为key, 若干本书集合为value
//        Map<String, Set<String>> autoidKey = new HashMap<String, Set<String>>(0);
        for (int k = 0; k < lines.size(); k++) {
            String line = lines.get(k);
            if (line.isEmpty() || !line.contains("@$@$@")) {
                continue;
            }
            String[] fields = new String[2];
            int index = line.indexOf("@$@$@");
            fields[0] = line.substring(0, index);
            fields[1] = line.substring(index + 5);
            line = null;

            if (fields[1].contains("&$&")) {

                String[] books = StringUtils.split(fields[1], "&$&");
                Set<String> temp = sidbidBooksMap.get(fields[0]);
                if (temp == null) {
                    temp = new HashSet<String>();
                }
                Collections.addAll(temp, books);
                sidbidBooksMap.put(fields[0], temp);
            } else {
                /*Set<String> tempBooksSet = sidbidBooksMap.get(fields[0]);
                if (tempBooksSet == null) {
                    tempBooksSet = new HashSet<String>();
                }
                tempBooksSet.add(fields[1]);
                sidbidBooksMap.put(fields[0], tempBooksSet);

                String autoID = fields[1].split("\\|")[0];
                Set<String> temp2 = autoidKey.get(autoID);
                if (temp2 == null) {
                    temp2 = new HashSet<String>();
                }
                temp2.add(fields[1]);
                autoidKey.put(autoID, temp2);*/

            }
        }
        lines.clear();

        Map<String, Set<String>> allSidbidBooksMap = new HashMap<String, Set<String>>();
        Iterator<Map.Entry<String, Set<String>>> iterator = sidbidBooksMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Set<String>> entry = iterator.next();
            if (entry.getValue().size() < 1) {
                continue;
            } else {
                Set<String> temp = allSidbidBooksMap.get(entry.getKey());
                if (temp == null) {
                    temp = new HashSet<String>();
                }
                for (String book : entry.getValue()) {
                    String[] bookInfo = book.split("\\|");
                    String sidbidKey = String.format("%s|%s", bookInfo[1], bookInfo[4]);
                    if (entry.getKey().equals(sidbidKey)) {
                        continue;
                    } else {
                        Set<String> matchbooksetOfOthers = allSidbidBooksMap.get(sidbidKey);
                        if (null != matchbooksetOfOthers) {
                            temp.addAll(matchbooksetOfOthers);
                        }
                    }
                }
                temp.addAll(entry.getValue());
                allSidbidBooksMap.put(entry.getKey(), temp);
            }
        }
        sidbidBooksMap.clear();
    }

    /**
     *     * 用分隔符将源串分为数组（String的该方法对split="|"失效,当split="*"时肯定出错！）
     *     * @param source  源字符串
     *     * @param split   分隔符
     *     * @return  数组
     *     * @throws Exception
     */

    public static String[] splitStr(String source, String split) {
        if (source == null || source.trim().equals("") || split == null || split.trim().equals("")) {
            return new String[]{};
        }
        int len = split.length();
        int index = -1;
        List<String> list = new ArrayList<String>();
        while ((index = source.indexOf(split)) != -1) {
            list.add(source.substring(0, index));
            source = getSubString(source, index + len);
        }
        if (!source.equals("")) {
            list.add(source);
        }
        return list.toArray(new String[list.size()]);
    }

    public static String getSubString(String s, int i) {
        return new String(s.substring(i));
    }

    public static String[] bulidDgraph(int key) {

       /* for (int i = 0; i < g1.length; i++) {

        }*/
        return new String[0];
    }
}
