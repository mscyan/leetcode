package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 组合总数 2
 * 无重复数组中，所有可以组合成SUM为target的所有元素组合，不可重复选取
 * tags: [数组], [回溯]
 * 经典的背包问题
 */
public class lc_40_combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dp(result, nums, target, 0, new ArrayList<>());
        return result;
    }

    public void dp(List<List<Integer>> result, int[] nums, int target, int index, List<Integer> list){

        if(target == 0){
            result.add(new ArrayList<>(list));
        }
        else if(target > 0){
            for(int i=index; i<nums.length; i++) {
                if(nums[i] > target){
                    return;
                }
                if(i > index && nums[i] == nums[i-1]){
                    continue;
                }
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                dp(result, nums, target-nums[i], i+1, newList);
            }
        }
    }

    public static void main(String[] args){

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> re = new lc_40_combinationSum2().combinationSum2(nums, 8);
        for(List<Integer> item : re){
            item.forEach((o) -> System.out.print(o + " "));
            System.out.println();
        }
    }
}
