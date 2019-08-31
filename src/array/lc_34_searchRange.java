package array;

import javax.lang.model.util.ElementFilter;
import javax.swing.*;
import java.awt.font.TextAttribute;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.TransferQueue;

/**
 * leetcode 34 找到排序数组中特定元素的首次和最后一次出现的位置
 * 数组是排序好的，如果不存在，则返回-1
 * tags: [数组], [二分查找]
 */
public class lc_34_searchRange {

    public int[] searchRange(int[] nums, int target){

        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        return bs(nums, target);
    }

    public int[] bs(int[] nums, int target){

        int left = findLeftIndex(nums, target);
        int right = findRightIndex(nums, target);
        int[] result = new int[]{left, right};

        return result;
    }

    private int findLeftIndex(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(nums[mid] == target){
                right = mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    private int findRightIndex(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                left = mid+1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        if(right <= 0 || nums[right-1] != target){
            return -1;
        }
        return right-1;
    }

    public static void main(String[] args){

        int[] nums = {1};
        System.out.println(Arrays.toString(new lc_34_searchRange().searchRange(nums, 0)));
    }
}
