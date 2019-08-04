package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 3 无重复字符的最长子串
 * 找出字符串中不含有重复字符的最长子串的长度
 * tags: [字符串], [双指针], [哈希表], [滑动窗口——Sliding Window]
 */
public class lc_3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        if(s.equals("")){
            return 0;
        }
        int max_len = 1;
        int left = 0, right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if(charMap.containsKey(c)){
                left = Math.max(charMap.get(c)+1, left);
                charMap.put(c, right);
            }
            else{
                charMap.put(c, right);
            }
            max_len = Math.max(max_len, (right-left+1));
            System.out.println("len: " + max_len);
            right++;
        }
        return max_len;
    }

    public static void main(String[] args){

        //          0123456789
        String s = "tmmzuxt";

        System.out.println(new lc_3_lengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
