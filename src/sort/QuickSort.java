package sort;

public class QuickSort {

    private int count = 0;

    public void sort(int[] nums){
        int len = nums.length;
        sort(nums, 0, len-1);
    }

    /**
     * 快排 平均时间复杂度为O(nlogn)，
     * 最差情况出现在数据基本有序（升序or降序），此时复杂度为O(n^2)，
     * 因为在有序情况下，需要对比n(n)次，内层n逐次减一，即n^2次
     * @param nums
     * @param left
     * @param right
     */
    public void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int flag = nums[left];
        int l = left;
        int r = right;
        while(l < r){
            while(r > l && nums[r] >= flag){
                r--;
                count++;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] <= flag){
                count++;
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = flag;
        sort(nums, left, l-1);
        sort(nums, l+1, right);
    }

    public static void main(String[] args){

//        int[] nums = {5, 1, 4, 3, 9, 2, 19, 23, 6};
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        QuickSort sort = new QuickSort();
        sort.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\ntotal count : " + sort.count);
    }

}
