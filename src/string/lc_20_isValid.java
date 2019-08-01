package string;

import java.util.Stack;

/**
 * leetcode 20 有效的括号
 * 判断一个串是否是有效的括号串，有效判断范围包括括号类型和左右对应
 * tags: [栈], [字符串]
 */
public class lc_20_isValid {

    public boolean isValid(String s){
        if(s.equals(""))
            return true;
        Stack<Character> charStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(charStack.isEmpty()){
                charStack.push(s.charAt(i));
                continue;
            }
            if(isPair(charStack.peek(), s.charAt(i))){
                charStack.pop();
            }
            else{
                charStack.push(s.charAt(i));
            }

        }
        return charStack.isEmpty();
    }

    private boolean isPair(char a, char b){
        if(a == '(' && b == ')')
            return true;
        if(a == '[' && b == ']')
            return true;
        if(a == '{' && b == '}')
            return true;
        return false;
    }

    public static void main(String[] args){

        String s = "([)]";
        System.out.println(new lc_20_isValid().isValid(s));
    }
}
