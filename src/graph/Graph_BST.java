package graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 广度优先搜索 breadth first search
 */
public class Graph_BST {

    private Node node;
    Queue<Node> Q = new ArrayBlockingQueue<>(10);

    public Graph_BST(Node node){
        this.node = node;
    }

    //广度优先搜索
    public void printAll(){
        for(Node item : node.neighbors){
            item.color = Color.WHITE;
            item.d = -1;
            item.parent = null;
        }
        node.parent = null;
        node.d = 0;
        node.color = Color.GRAY;
        Q.add(node);
        while(Q.size() != 0){
            Node u = Q.poll();
            for(Node v : u.neighbors){
                if(v.color == Color.WHITE){
                    v.color = Color.GRAY;
                    v.d = u.d + 1;
                    v.parent = u;
                    Q.add(v);
                }
            }
            u.color = Color.BLACK;
            System.out.println(u.val);
        }
    }


    public static void main(String[] args){

        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;

        Node node4 = new Node();
        node4.val = 4;

        Node node5 = new Node();
        node5.val = 5;

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node4);
        node3.neighbors.add(node5);

        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        node4.neighbors.add(node5);

        node5.neighbors.add(node3);
        node5.neighbors.add(node4);

        Graph_BST bst = new Graph_BST(node5);
        bst.printAll();;
    }
}
