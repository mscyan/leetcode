package unionfind;

import java.util.HashMap;

/**
 * leetcode 128 最长连续序列
 * 找出一个乱序数组中最长的连续序列的长度
 * tags: [数组], [并查集]
 */
public class lc_128_longestConsecutive {

    public int longestConsecutive(int[] nums){
        if(nums.length == 1)
            return 1;

        int len = 0;
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int k = nums[i];
            if(intMap.containsKey(k))
                continue;
            boolean left = intMap.containsKey(k-1);
            boolean right = intMap.containsKey(k+1);
            if(left && !right){
                int length = intMap.get(k-1) + 1;
                intMap.put(k, length);
                intMap.put(k-(length-1), length);
                len = Math.max(length, len);
            }
            else if(!left && right){
                int length = intMap.get(k+1) + 1;
                intMap.put(k, length);
                intMap.put(k+(length-1), length);
                len = Math.max(length, len);
            }
            else if(left && right){
                int l_length = intMap.get(k-1) + 1;
                int r_length = intMap.get(k+1) + 1;
                intMap.put(k, l_length+r_length-1);
                intMap.put(k-(l_length-1), l_length+r_length-1);
                intMap.put(k+(r_length-1), l_length+r_length-1);
                len = Math.max((l_length + r_length - 1), len);
            }
            else {
                intMap.put(k, 1);
                len = Math.max(len, 1);
            }
        }


        return len;
    }

    public static void main(String[] args){
        int[] arr = new int[]{};

        System.out.println(new lc_128_longestConsecutive().longestConsecutive(arr));
    }
}
