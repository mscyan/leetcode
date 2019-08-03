package string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 30 串联所有单词的子串
 * 字符串中可以用子串数组中所有元素组成的串作为子串的起始位置
 * tags: [字符串], [哈希表], [双指针]
 */
public class lc_30_findSubstring {

    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> list = new ArrayList<>();


        return list;
    }

    public static void main(String[] args){

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        new lc_30_findSubstring().findSubstring(s, words).forEach(System.out::println);
    }
}
