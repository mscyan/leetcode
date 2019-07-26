package tree;

import java.util.Stack;

public class Tree {

    void inOrder(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> inStack = new Stack();
        TreeNode p = root;
        while(!inStack.empty() || p != null){
            while(p != null){
                inStack.push(p);
                p = p.left;
            }
            p = inStack.pop();//最左孩子
            System.out.println(p.value);
//            if(p.right != null){
                p = p.right;
//            }
        }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);

        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;

        ll.left = new TreeNode(8);

        new Tree().inOrder(root);
    }
}
