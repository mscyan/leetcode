package array;

import java.util.*;

/**
 * leetcode 三数之和
 * 在给定数组中找到所有的和为0的三个元素
 * tags: [数组], [双指针]
 */
public class lc_15_threeSum {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                //排序过后，重复的不再重新扫描，因为会得出重复的数组结果
                continue;
            }
            int k = 0-nums[i];
            if(-k > 0)
                break;

            Map<Integer, Integer> indexMap = new HashMap<>();
            for(int j=i+1; j<nums.length; j++){

                if(indexMap.containsKey(nums[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(-k);
                    list.add(nums[j]);
                    list.add(nums[indexMap.get(nums[j])]);
                    result.add(list);
                }
                indexMap.put(k-nums[j], j);
            }
            int x = 0;
        }
        return result;

        //此方法不能过所有测试用例，比如 [0,0,0,0]
    }

    // 双指针解
    public List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int FLAG = nums[i];
            if(FLAG > 0)
                continue;

            int l = i+1, r = nums.length-1;
            while(l < r){
                int sum = FLAG + nums[l] + nums[r];
                if(sum == 0){
                    result.add(Arrays.asList(FLAG, nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum > 0){
                    r--;
                }
                else
                    l++;
            }
        }
        return result;
    }

    public static void main(String[] args){

        int[] nums = {0, 0, 0, 0};
        //  -4, -1, -1, 0, 1, 2

        List<List<Integer>> result = new lc_15_threeSum().threeSum2(nums);
        System.out.println("SIZE : " + result.size());
        for(List<Integer> tuple : result){
            for(Integer i : tuple){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
