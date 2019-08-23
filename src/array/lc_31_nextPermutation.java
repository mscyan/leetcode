package array;

import javax.management.Descriptor;
import java.util.Arrays;
import java.util.Collections;

/**
 * leetcode 31 下一个排列
 * 将给定的 数字 序列按照字典序排列成下一个排列，如果是降序则恢复为升序
 * tags: [数组]
 */
public class lc_31_nextPermutation {

    public void nextPermutation(int[] nums){

        if(nums == null || nums.length == 0 || nums.length == 1)
            return;

        //todo 不理解解法
    }

    public static void main(String[] args){

        int[] nums = {1, 3, 2};
        new lc_31_nextPermutation().nextPermutation(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
