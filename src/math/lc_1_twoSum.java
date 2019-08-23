package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1 两数之和
 * 找出数组中和为target的两个整数
 * tags: [数组], [哈希表]
 */
public class lc_1_twoSum {

    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return null;
        }
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    int[] re = new int[]{nums[i], nums[j]};
                    return re;
                }
            }
        }

        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(indexMap.containsKey(nums[i])){
                int[] re = new int[]{indexMap.get(nums[i]), i};
                return re;
            }
            indexMap.put(target-nums[i], i);
        }

        return null;
    }

    public static void main(String[] args){

        int[] nums = {3, 3};

        System.out.println(Arrays.toString(new lc_1_twoSum().twoSum2(nums, 6)));
    }
}
