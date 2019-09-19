package Interview.t_20190910_leyan;

import java.io.*;
import java.util.*;

public class question1 {

    /**
     * 读取一个英文文本，将其中出现的单词按其出现的顺序 升序输出
     * 格式： [word] [次数]
     * @param args
     */
    //某些情况会爆内存
    public static void main(String[] args){

        String path = "C:\\Users\\yanchao\\IdeaProjects\\leetcode\\src\\Interview\\t_20190910_leyan\\article.txt";
        StringBuilder sb = new StringBuilder();
        try{
            Reader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String sentence = null;
            while((sentence = bufferedReader.readLine()) != null){
                sb.append(sentence).append(";");
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        String s = sb.toString();
        int left = 0, right = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')){
                right++;
            }
            else{
                // 统计到了单词
                if(right - left > 0){
                    String word = s.substring(left, right);
                    if(map.containsKey(word)){
                        map.put(word, map.get(word) + 1);
                    }
                    else{
                        map.put(word, 1);
                    }
                    right++;
                    left = right;
                }
                else{
                    right++;
                    left++;
                }
            }
        }
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, String> nmap = new HashMap<>();
//        for(Integer i : map.values()){
//
//        }
        List<String> strings = new ArrayList<>();
        for(String key : map.keySet()){
//            System.out.println(key + " " + map.get(key));
            strings.add(key);
        }
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(int i=0; i<strings.size(); i++){
            System.out.println(strings.get(i) + " " + map.get(strings.get(i)));
        }
    }
}
