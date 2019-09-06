package dp;

/**
 * leetcode 5 最长回文子串
 * 求出一个字符串s中最长的回文子串
 * tags: [动态规划], [字符串]
 */
public class lc_5_longestPalindrome {

    //一个串是回文串的前提是，它的子串是回文串并且头尾字符相同
    // 比如 s = abbba，已求得bbb是回文串的情况下，发现bbb的前一个字符和bbb的后一个字符都是a，那么
    // 很显然，加上这两个字符的串也是回文串，之后遍历dp数组即可求得最大的跨度
    public String longestPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
            }
        }
        for(int i=len-1; i>=0; i--){
            for(int j=i+1; j<len; j++){
                if(j - i == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j) ? 1 : 0);
                }
                if(j - i > 1){
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1)
                        dp[i][j] = 1;
                }
            }
        }
        int left = 0, right = 0, max = 1;
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(dp[i][j] == 1){
                    if((j-i+1) > max){
                        left = i;
                        right = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(left, right+1);
    }


    public static void main(String[] args){

        String s = "babad";
        System.out.println(new lc_5_longestPalindrome().longestPalindrome(s));
    }
}
