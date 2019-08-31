package array;

import java.util.*;

/**
 * leetcode 39 组合总数
 * 无重复元素数组中，可以组成和为target的所有组合，可重复选取
 * tags: [数组], [回溯]
 */
public class lc_39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dp(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    public void dp(List<List<Integer>> result, int[] nums, int target, List<Integer> list, int left){
        if(target == 0){
            List<Integer> newList = new ArrayList<>(list);
            result.add(newList);
        }
        else if(target > 0){
            for(int i=left; i<nums.length; i++){

                if(nums[i] > target){
                    return;
                }
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                //需要保证 新选择的数 不能比原list中最大的数还大
                int max = Integer.MIN_VALUE;
                for(Integer item : newList){
                    max = Math.max(item, max);
                }
                if(nums[i] >= max){
                    dp(result, nums, target-nums[i], newList, i);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 6, 7};

        List<List<Integer>> re = new lc_39_combinationSum().combinationSum(nums, 7);
        for(List<Integer> item : re){
            item.forEach((o) -> System.out.print(o + " "));
            System.out.println();
        }
    }
}
