package unionfind;

/**
 * 并查集
 */
public class UnionFind {

    private int node[];

    public UnionFind(int[] arr){
        this.node = arr;
    }

    /**
     * 找到根节点
     * @param value
     */
    public int unionSearch(int value){
        if(value > node.length){
            return -1;
        }
        int findCount = 0;
        int temp = value;
        if(temp == node[value]){
            System.out.println("times: " + value + " -> findCount " + findCount);
            return value;
        }
        while(temp != node[temp]){
            temp = node[temp];
            findCount++;
        }
        System.out.println("times: " + value + " -> findCount " + findCount);
        return temp;
    }

    /**
     * 将两个分支连通起来
     */
    public void join(int g1, int g2){
        int root1 = unionSearch(g1);
        int root2 = unionSearch(g2);
        if(root1 != root2){
            node[root2] = node[root1];
        }
        //todo 路径压缩算法，降低树的深度；
    }

    public static void main(String[] args){
        int[] arr = {0, 1, 1, 0, 2, 0, 6, 4, 0, 6, 11, 10};
        UnionFind unionFind = new UnionFind(arr);
        System.out.println(unionFind.unionSearch(7));
        System.out.println(unionFind.unionSearch(9));
        unionFind.join(7,9);
        System.out.println(unionFind.unionSearch(7));
        System.out.println(unionFind.unionSearch(9));
    }
}
