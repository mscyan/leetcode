package string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 14 最长公共前缀
 * 找到一个字符串数组中的最长公共前缀
 * tags: [字符串]
 */
public class lc_14_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        String prefix = "";

        //特殊条件判断
        if(strs == null || strs.length == 0)
            return prefix;
        for(int i=0; i<strs.length; i++){
            if(strs[i] == null || strs[i].equals("")){
                return prefix;
            }
        }
        HashMap<Character, Map> map = new HashMap<>();
        HashMap<Character, Map> p = map;
        int index = 0;
        for(index = 0; ; index++){
            for(int i=0; i<strs.length; i++){
                if(strs[i].length() < index+1){
                    map.clear();
                    break;
                }

                char c = strs[i].charAt(index);
                if(map.containsKey(c)){

                }
                else if(!map.containsKey(c) && i > 0){
                    map.put(c, new HashMap());
                    break;
                }
                else if(!map.containsKey(c) && i == 0){
                    map.put(c, new HashMap<Character, Map>());
                }
            }
            if(map.keySet().size() != 1){
                break;
            }
            else{
                map = (HashMap<Character, Map>) map.get(strs[0].charAt(index));
            }
        }
        StringBuilder b = new StringBuilder("");
        while(true){
            if(p == null || p.keySet().size() != 1){
                break;
            }
            else{
                char c = p.keySet().iterator().next();
                b.append(c);
                p = (HashMap<Character, Map>) p.get(c);
            }
        }
        prefix = b.toString();
        return prefix;
    }

    public static void main(String[] args){

        String[] strs = {"f"};
        System.out.println(new lc_14_longestCommonPrefix().longestCommonPrefix(strs));
    }
}
