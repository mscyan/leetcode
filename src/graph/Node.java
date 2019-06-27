package graph;

import java.util.List;

/**
 * 图的节点的抽象表示方法，用于邻接链表
 * Vertex
 */
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node(){}

    public Node(int _val, List<Node> _neighbors){
        this.val = _val;
        this.neighbors = _neighbors;
    }
}
