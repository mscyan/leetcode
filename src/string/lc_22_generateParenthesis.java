package string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22 括号生成
 * 根据给定的n，生成所有可能的有效的括号组合
 * tags: [字符串], [回溯]
 */
public class lc_22_generateParenthesis {
    private int cnt = 0;
    public List<String> generateParenthesis(int n){
        List<String> parenthesises = new ArrayList<>();

        //method 1
        generate_method_1(parenthesises, 0, 0, "", n);
        System.out.println(cnt);
        return parenthesises;
    }

    public void generate_method_1(List<String> list, int left, int right, String string, int n){
        if(right > left)
            return;
        if(left > n || right > n)
            return;
        if(right == n){
//            if(new lc_20_isValid().isValid(string))
                list.add(string);
            return;
        }
        cnt++;
        generate_method_1(list, left+1, right, string+"(", n);
        generate_method_1(list, left, right+1, string+")", n);
    }

    public static void main(String[] args){

        int n = 3;
        List<String> parenthesises = new lc_22_generateParenthesis().generateParenthesis(n);
        parenthesises.forEach((item) -> System.out.println(item));
    }
}
