package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17 电话号码的字母组合
 * 根据给出的按键（如345），给出所有待输出的字符串数组
 * tags: [字符串], [回溯]
 */
public class lc_17_letterCombinations {

    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        if(digits.equals(""))
            return result;
        dfs(result, 0, digits, "", map);
        return result;
    }

    // 326
    public void dfs(List<String> result, int index, String digits, String current, Map<Integer, String> map){
        String value = map.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
        if(index == digits.length()-1){
            for(int i=0; i<value.length(); i++){
                result.add(current+value.charAt(i));
            }
            return;
        }
        else{
            for(int i=0; i<value.length(); i++){
                dfs(result, index+1, digits, current+value.charAt(i), map);
            }
        }
    }

    public static void main(String[] args){

        // input should be in 2~9
        String input = "";
        new lc_17_letterCombinations().letterCombinations(input)
                .forEach((item) -> System.out.print(item + " "));
    }
}
