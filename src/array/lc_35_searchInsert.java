package array;

/**
 * leetcode 35 搜索插入位置
 * 在排序数组中找到目标值，若不存在则返回应插入的下标
 * tags: [数组], [二分查找]
 */
public class lc_35_searchInsert {

    public int searchInsert(int[] nums, int target){
        int index = findFirstIndexForTarget(nums, target);

        if(index >= nums.length){
            return nums.length;
        }
        else if(nums[index] != target){
            return index;
        }
        else{
            return index;
        }
    }

    private int findFirstIndexForTarget(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left+right) / 2;
            if(nums[mid] == target){
                right = mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args){

        int[] nums = {0};

        System.out.println(new lc_35_searchInsert().searchInsert(nums, 5));
        System.out.println(new lc_35_searchInsert().searchInsert(nums, 2));
        System.out.println(new lc_35_searchInsert().searchInsert(nums, 7));
        System.out.println(new lc_35_searchInsert().searchInsert(nums, 0));

    }
}
