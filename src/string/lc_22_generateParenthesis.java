package string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22 括号生成
 * 根据给定的n，生成所有可能的有效的括号组合
 * tags: [字符串], [回溯]
 */
public class lc_22_generateParenthesis {

    public List<String> generateParenthesis(int n){
        List<String> parenthesises = new ArrayList<>();

        return parenthesises;
    }

    public static void main(String[] args){

        int n = 3;
        List<String> parenthesises = new lc_22_generateParenthesis().generateParenthesis(n);
        parenthesises.forEach((item) -> System.out.println(item));
    }
}
