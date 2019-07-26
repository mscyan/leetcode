package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//拓扑排序
public class TopologicalSort {

    private List<Node> nodes_G = new ArrayList<>();

    //需要判断是否具有环路，具有环路的有向图无法进行拓扑排序
    public TopologicalSort(){

    }

    //判断图是否有后向边
    private boolean hasBackEdge(){
        return false;
    }

    /**
     * call DFS(G) to compute finishing times v.f for each vertex v
     * as each vertex is finished, insert it onto the front of a linked list
     * return the linked list of vertices
     * from 算法导论
     */
    public void TopologicalSortPrintAll(){
        Graph_DST graph_dst = new Graph_DST();
        for(Node v : nodes_G){
            graph_dst.addNode(v);
        }
        graph_dst.printAll();

        (nodes_G).sort(Comparator.comparingInt(o -> -o.f));
        for(Node v : nodes_G){
            System.out.print(v.val + " ");
        }
    }

    public void addNode(Node node){
        this.nodes_G.add(node);
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

        node2.neighbors.add(node3);
        node2.neighbors.add(node4);

        node3.neighbors.add(node4);

//        node4.neighbors.add(node1);

        node6.neighbors.add(node5);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.addNode(node1);
        topologicalSort.addNode(node2);
        topologicalSort.addNode(node3);
        topologicalSort.addNode(node4);
        topologicalSort.addNode(node5);
        topologicalSort.addNode(node6);

        topologicalSort.TopologicalSortPrintAll();
    }
}
