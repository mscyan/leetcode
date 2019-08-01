package array;

import java.util.Arrays;

/**
 * leetcode 26 删除排序数组中的重复项
 * 原地修改输入数组，可用额外空间：O(1)
 * tags: [数组], [双指针]
 */
public class lc_26_removeDuplicates {

    public int removeDuplicates(int[] nums){
        if(nums == null)
            return 0;
        if(nums.length == 1 || nums.length == 0)
            return nums.length;

        int j=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }



    public static void main(String[] args){

        int[] arr = {1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 10};
        int len = new lc_26_removeDuplicates().removeDuplicates(arr);
        System.out.println(len);
        System.out.println(Arrays.toString(arr));
    }
}
