package string;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * leetcode 30 串联所有单词的子串
 * 字符串中可以用子串数组中所有元素组成的串作为子串的起始位置，需要注意的是，所有的单词长度相同！
 * tags: [字符串], [哈希表], [双指针]
 */
public class lc_30_findSubstring {

    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length == 0){
            return list;
        }
        int len = words[0].length();
        if(s == null || s.equals("")){
            return list;
        }
        if(s.length() < (len * words.length)){
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i]))
                map.put(words[i], 1);
            else
                map.put(words[i], map.get(words[i])+1);
        }
        for(int i=0;i<(s.length() - len*words.length)+1;i++){
            HashMap<String, Integer> tempMap = new HashMap<>();
            boolean check = true;
            for(int j=i; j<i+words.length*len; j+=len){
                String tempString = s.substring(j, j+len);
                if(!map.containsKey(tempString)){
                    check = false;
                    break;
                }
                else{
                    tempMap.put(tempString, tempMap.get(tempString) == null ? 1 : tempMap.get(tempString)+1);
                    if(tempMap.get(tempString) > map.get(tempString)){
                        check = false;
                        break;
                    }
                }
            }
            for(String key : map.keySet()){
                if(tempMap.get(key) == null || tempMap.get(key) != map.get(key))
                    check = false;
            }
            if(check)
                list.add(i);

        }
        return list;
    }


    public List<Integer> findSubstring2(String s, String[] words){
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length == 0)
            return list;
        int _LEN = words[0].length();
        if(s == null || s.equals(""))
            return list;
        if(s.length() < (_LEN * words.length))
            return list;


        HashMap<String, Integer> globalMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!globalMap.containsKey(words[i]))
                globalMap.put(words[i], 1);
            else
                globalMap.put(words[i], globalMap.get(words[i])+1);
        }
        for(int start=0; start<_LEN; start++){
            HashMap<String, Integer> tempMap = new HashMap<>();
            int COUNT = 0;
            for(int i=start; i<(s.length()-_LEN*words.length)+1; i+=_LEN){
                //虽然是两个for循环，但由于根据len将遍历的次序岔开，本质上还是n次内循环。

                System.out.println("index: " + i);
                boolean check = true;
                for(int j=i+_LEN*COUNT; j<(i+words.length*_LEN); j+=_LEN){
                    String subS = s.substring(j, j+_LEN);
                    if (!globalMap.containsKey(subS)) {
                        tempMap.clear();
                        check = false;
                        i = j;
                        break;
                    }
                    else{
                        tempMap.put(subS, tempMap.get(subS) == null ? 1 : tempMap.get(subS) + 1);
                        if(tempMap.get(subS) > globalMap.get(subS)){
                            check = false;
                            break;
                        }
                    }
                }
                for(String key : globalMap.keySet()){
                    if(tempMap.get(key) == null || tempMap.get(key) != globalMap.get(key))
                        check = false;
                }
                if(check){
                    list.add(i);
                    COUNT = words.length-1;
                    String x = s.substring(i, i+_LEN);
                    tempMap.put(x, tempMap.get(x)-1);
                }
                else{
                    COUNT = 0;
                    tempMap.clear();
                }
            }
            tempMap.clear();
        }
        return list;
    }

    public static void main(String[] args){

        String s = "aabbccbbaaee";
        String[] words = {"aa", "bb", "ee"};
        new lc_30_findSubstring().findSubstring2(s, words).forEach(System.out::println);
    }
}
