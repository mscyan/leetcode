package array;

/**
 * leetcode 11 盛最多水的容器
 * 找到可以容纳水面积最多的两个边
 * tags: [数组], [双指针]
 */
public class lc_11_maxArea {

    public int maxArea(int[] height){
        int area = 0;
        int l = 0, r = height.length-1;

        while(l<r){
            if(height[l] < height[r]){
                area = Math.max(area, (r-l) * height[l]);
                l++;
            }
            else{
                area = Math.max(area, (r-l) * height[r]);
                r--;
            }
        }

        return area;
    }

    public static void main(String[] args){

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(new lc_11_maxArea().maxArea(arr));
    }
}
