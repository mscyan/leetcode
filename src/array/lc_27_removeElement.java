package array;

import java.util.Arrays;

/**
 * leetcode 27 移除数组中所有等于val的元素
 * 原地修改数组，可使用额外空间：O(1)
 * tags: [数组], [双指针]
 */
public class lc_27_removeElement {

    public int removeElement(int[] nums, int val){
        if(nums == null)
            return 0;
        if(nums.length == 0)
            return 0;

        int j=nums.length-1;
        for(int i=0; i<=j; i++){
            if(nums[i] == val){
                while(nums[j] == val && j > i){
                    j--;
                }
                nums[i] = nums[j];
                j--;
            }
        }
        return j+1;
    }

    public static void main(String[] args){

        int[] arr = {4, 5};
        int len = new lc_27_removeElement().removeElement(arr, 5);
        System.out.println(len);
        System.out.println(Arrays.toString(arr));
    }
}
