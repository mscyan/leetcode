package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 133 克隆图
 */

public class CloneGraph {

    // 用于放置 value 对应的 Vertex节点，避免重复克隆
    private Map<Integer, Node> map = new HashMap<>();

    /**
     * 给定一个无向连通图中的一个节点，返回该Graph的深拷贝
     * @param node
     * @return
     */
    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node.val)){
            return node;
        }
        //该节点尚未被拷贝
        Node p = new Node(node.val, new ArrayList<>());
        map.put(p.val, p);
        for(Node item : node.neighbors){
            if(map.containsKey(item.val)){
                p.neighbors.add(map.get(item.val));
            }
            else{
                Node clonedNode = cloneGraph(item);
                map.put(item.val, clonedNode);
                p.neighbors.add(clonedNode);
            }
        }
        return p;
    }

    public static void main(String[] args){


    }
}
