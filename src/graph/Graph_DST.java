package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索 depth first search
 */
public class Graph_DST {

    private Node node;
    private int time;
    private List<Node> nodes_G = new ArrayList<>();
    private boolean hasBackEdge = false;

    public Graph_DST(){

    }

    public void addNode(Node node){
        nodes_G.add(node);
    }

    /**
     * 深度优先搜索
     */
    public void printAll(){
        for(Node v : nodes_G){
            v.color = Color.WHITE;
            v.parent = null;
        }
        time = 0;
        for(Node v : nodes_G){
            if(v.color == Color.WHITE){
                DFS(v);
            }
            else{
//                System.out.println("Node had been visited, value is : " + v.val);
            }
//            System.out.println(time);
        }
    }

    private void DFS(Node u){
        time = time + 1;
        u.d = time;
        u.color = Color.GRAY;
//        System.out.print(" (" + u.val);
        for(Node v : u.neighbors){
            if(v.color == Color.WHITE){
                v.parent = u;
                DFS(v);
            }
        }
        u.color = Color.BLACK;
        time = time + 1;
        u.f = time;
//        System.out.print(u.val + ") ");
//        System.out.println(u.val);
    }

    public static void main(String[] args){

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();

        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        node5.neighbors.add(node6);
        node6.neighbors.add(node5);

        Graph_DST graph_dst = new Graph_DST();
        graph_dst.addNode(node1);
        graph_dst.addNode(node2);
        graph_dst.addNode(node3);
        graph_dst.addNode(node4);
        graph_dst.addNode(node5);
        graph_dst.addNode(node6);

        graph_dst.printAll();
        System.out.println();
    }
}
