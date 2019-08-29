package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * leetcode 32 最长有效括号
 * 给定一个只包含 ( 和 ) 的字符串，找出最长的包含有效括号子串的长度
 * tags: [字符串], [动态规划]
 */
public class lc_32_longestValidParenthesis {

    public int longestValidParenthesis(String s){
        int len = 0;

        if(s == null || s.length() == 0){
            return 0;
        }

        len = method1_dp(s);

        return len;
    }

    public int method1_dp(String s){
        int len = 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }
            else{
                // ()
                if(s.charAt(i-1) == '('){
                    dp[i] = 2 + (i >= 2 ? dp[i-2] : 0);
                }
                // ))
                else if((i-dp[i-1] > 0) &&  s.charAt(i-1) == ')' && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = 2 + dp[i-1] + ((i-dp[i-1] >= 2) ? dp[i-dp[i-1]-2] : 0);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    public static void main(String[] args){

        String s = ")()())";
        System.out.println(new lc_32_longestValidParenthesis().longestValidParenthesis(s));
    }
}
