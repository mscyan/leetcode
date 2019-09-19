package 一些面试题;

import util.linkedlist.Node;

/**
 * 网上看到的一道头条的翻转链表，每k个节点翻转一次，从尾部开始反转，头部不够k个的节点不反转
 * 比如 1-2-3-4-5-6-7-8  k=3
 * 输出 1-2-5-4-3-8-7-6
 */
public class reverseList {

    // 最简单的反转
    public Node reverseList(Node node){
        if(node == null || node.next == null)
            return null;

        Node head = new Node(0);
        head.next = node;

        Node temp = null;
        while(node.next != null){
            temp = node.next;
            node.next = node.next.next;
            temp.next = head.next;
            head.next = temp;
        }
        return head.next;
    }

//    public Node reverseList2(Node node){
//        if(node == null){
//            return null;
//        }
//        if(node.next == null){
//            return node;
//        }
//        Node head = new Node(-1);
//        Node p = head;
//        head.next = node;
//        Node temp = null;
//
//        return p.next;
//    }

    // k个一组反转
    public Node reverseList(Node node, int k){
        if(node == null){
            return null;
        }
        Node head = new Node(-1);
        head.next = node;
        Node p = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        int step = len % k;
        while(step > 0){
            head = head.next;
            step--;
        }
        Node temp = null;
        while(true){
            int count = k;
            node = head.next;
            while(count > 1){
                count--;
                temp = node.next;
                node.next = node.next.next;
                temp.next = head.next;
                head.next = temp;
            }
            head = node;
            if(head.next == null){
                break;
            }
        }
        return p.next;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node p = head;
        head.next = new Node(2);
        head = head.next;
        head.next = new Node(3);
        head = head.next;
        head.next = new Node(4);
        head = head.next;
        head.next = new Node(5);
        head = head.next;
        head.next = new Node(6);
        head = head.next;
        head.next = new Node(7);
        head = head.next;
        head.next = new Node(8);
//        head = head.next;
//        head.next = new Node(9);

        head = new reverseList().reverseList(p);
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
