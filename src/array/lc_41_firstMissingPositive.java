package array;

/**
 * leetcode 41 缺失的第一个正数
 * 找出给定的未排序整数数组中没有出现的最小的整数
 * tags: [数组]
 * 需要时间复杂度为On，空间复杂度为O1
 */
public class lc_41_firstMissingPositive {

    public int firstMissingPositive(int[] nums){
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0 || nums[i] > nums.length){
                nums[i] = 0;
            }
        }
        int len = nums.length+2;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0 && nums[i] != -len){
                if(nums[Math.abs(nums[i])-1] == 0)
                    nums[Math.abs(nums[i])-1] = -len;
                else
                    nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return nums.length+1;
    }


    public static void main(String[] args){

        int[] nums = {3, 4, 0, 2};
//        int[] nums = {1, 2, 3, 4, 7, 6, 7, 8};
        System.out.println(new lc_41_firstMissingPositive().firstMissingPositive(nums));
    }
}
