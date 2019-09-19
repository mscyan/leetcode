package Interview.t_20190910_leyan;

import java.util.*;

public class question3 {

    public Character maxF(String s){
        if(s == null || s.equals(""))
            return null;

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a'))
            {
                if(c <= 'Z' && c >= 'A'){
                    c = (char) ('a' + (c-'A'));
                }
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }
                else{
                    map.put(c, 1);
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for(Character c : map.keySet()){
            list.add(c);
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(map.get(o1) - map.get(o2) == 0){
                    return o2 - o1;
                }
                else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });
        return list.get(list.size()-1);
    }

    public static void main(String[] args){
        String s = "ccddeeffgghhhABDe12Daa";

        System.out.println(new question3().maxF(s));

        System.out.println(1024/2 * 1024*1024);
    }
}
