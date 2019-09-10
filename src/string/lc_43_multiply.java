package string;

import java.util.Arrays;

/**
 * 字符串相乘
 * 将给定的两个字符串表示的整数进行相乘，返回乘积，len(x)小于110
 * tags: [数学], [字符串]
 * 类似大整数乘法，不可用库函数
 */
public class lc_43_multiply {

    public String multiply(String num1, String num2){
        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        int[] result = new int[num1.length() + num2.length()];


        return Arrays.toString(result);
    }

    public static void main(String[] args){
        String num1 = "";
        String num2 = "";

        System.out.println(new lc_43_multiply().multiply(num1, num2));
    }
}
