package 一些面试题;

import util.tree.Tree;
import util.tree.TreeNode;

import java.util.Stack;

/**
 * v2 看到的一道面试题
 * 将'1(2(3,4(,5)),6(7,))' 这个串转成二叉树
 *      1
 *    /   \
 *   2     6
 *  / \   / \
 * 3   4 7
 *      \
 *       5
 */
public class string_to_tree {

    public TreeNode stringToTree(String s){
        TreeNode root = DFS(s);
        return root;
    }

    // 2(3,4(,5)),6(7,)
    public TreeNode DFS(String s){
        int len = s.length();
        if(len < 5){
            if(len == 0){
                return null;
            }
            else if(len == 1){
                return new TreeNode(Integer.parseInt(s));
            }
        }
        int val = Integer.parseInt(String.valueOf(s.charAt(0)));
        TreeNode node = new TreeNode(val);

        String innerString = s.substring(2, len-1);
        Stack<Character> stack = new Stack<>();

        int flag = -1;
        if(innerString.length() >= 5){
            for(int i=0; i<innerString.length(); i++){
                char c = innerString.charAt(i);
                stack.push(c);
                if(c == ')'){
                    while(true){
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        else{
                            stack.pop();
                        }
                    }
                }
                flag++;
                if(c == ',' && stack.size() == 2){
                    break;
                }
            }
        }
        else {
            flag = innerString.indexOf(',');
        }
        TreeNode leftNode = DFS(innerString.substring(0, flag));
        TreeNode rightNode = DFS(innerString.substring(flag+1, innerString.length()));
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public static void main(String[] args){
        String s = "1(2(3,4(,5)),6(7,))";
        TreeNode root = new string_to_tree().stringToTree(s);
        new Tree().postOrder(root);
        System.out.println();
    }
}
