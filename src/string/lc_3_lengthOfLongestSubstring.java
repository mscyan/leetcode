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
                //如果 两个相同字符相邻，则直接取get(c)+1即可
                //但是如果这两个字符之间有其他字符修改了left的位置，此时get(c)+1无法得出正确位置
                //需要直接使用被重置之后的left的下标，如abcddeaf，dd就修改了left的位置，但get('a')还是0
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
        String s = "abbba";

        System.out.println(new lc_3_lengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
