package array;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * leetcode 42 接雨水
 * 给定的表示柱子高度的数组中，总共可以接多少雨水
 * tags: [数组], [双指针]
 */
public class lc_42_trap {

    public int trap(int[] height){
        if(height == null || height.length <= 2){
            return 0;
        }
        int sum = 0;
        int l = 0, r = 1;
        int maxIndex = 0;

        return sum;
    }

    public static void main(String[] args){

        int[] height = {5, 4, 3, 1, 8, 4, 1, 5};
        System.out.println(new lc_42_trap().trap(height));
    }
}
