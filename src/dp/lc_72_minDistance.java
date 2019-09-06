package dp;

/**
 * leetcode 72 编辑距离
 * 给定两个单词，计算出将word1转换成word2需要的最少操作次数，操作包含insert，delete，replace
 * tags: [动态规划], [字符串]
 */
public class lc_72_minDistance {

    // dp[i][j] 表示从word1的第i位转换到word2的第j位需要的最少次数，所以
    // 一开始需要初始化dp数组，dp[i][j]边上的所有元素需要填充为对应的非0下标
    // 比如dp[0][5] = 5，表示从一个空串转换为另一个长度非5的串，显然需要5次
    // 之后，计算出从word1的每一位转换到word2的每一位需要的次数，dp[i][j]依赖于
    // dp[i-1][j]  dp[i-1][j-1]  dp[i][j-1]这三个位置的值，其中{
    //      dp[i-1][j]  表示delete操作，因为word1删除一个元素后可以转换为word2
    //      dp[i-1][j-1]    表示replace操作
    //      dp[i][j-1]  表示add操作
    // }
    // 之后，遍历i，j即可获取最后的结果次数
    public int minDistance(String word1, String word2){
        if(word1.equals("") && word2.equals(""))
            return 0;
        if(word1.equals("") && !word2.equals(""))
            return word2.length();
        if(!word1.equals("") && word2.equals(""))
            return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++){
            for(int j=0; j<=word2.length(); j++){
                if(i == 0 && j != 0){
                    dp[0][j] = j;
                }
                else if(j == 0 && i != 0){
                    dp[i][0] = i;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args){

        String s1 = "horse";
        String s2 = "ros";
        System.out.println(new lc_72_minDistance().minDistance(s1, s2));
    }
}
