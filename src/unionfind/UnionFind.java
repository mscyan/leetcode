package unionfind;

/**
 * 并查集
 */
public class UnionFind {

    private int node[];
    private int groupCount = 0;
    private int[] rank;

    public UnionFind(int[] arr){
        this.node = arr;
//        for(int i=0;i<node.length;i++){
//            node[i] = i;
//        }
        groupCount = node.length;
        this.rank = new int[arr.length];
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
        int groupRoot = value;
        if(groupRoot == node[value]){
            System.out.println("times: " + value + " -> findCount " + findCount);
            return value;
        }
        while(groupRoot != node[groupRoot]){
            groupRoot = node[groupRoot];
            findCount++;
        }

        // 路径压缩算法；
        int r = value;
        while(r != groupRoot){
            int temp = node[r];
            node[r] = groupRoot;
            r = temp;
        }
        System.out.println("times: " + value + " -> findCount " + findCount);
        return groupRoot;
    }

    /**
     * 将两个分支连通起来
     * //todo 秩优化，降低合并之后的树的深度；
     */
    public void join(int g1, int g2){
        int root1 = unionSearch(g1);
        int root2 = unionSearch(g2);
        if(root1 != root2){
            node[root2] = root1;
            groupCount--;
        }
    }

    public boolean isConnected(int g1, int g2){
        return this.unionSearch(g1) == this.unionSearch(g2);
    }

    public static void main(String[] args){
        //           0  1  2  3  4  5  6  7  8  9  10 11
        int[] arr = {0, 1, 1, 0, 2, 0, 6, 4, 0, 6, 9, 7};
        UnionFind unionFind = new UnionFind(arr);
//        System.out.println(unionFind.unionSearch(7));
//        System.out.println(unionFind.unionSearch(9));
//        unionFind.join(7,9);
//        System.out.println(unionFind.unionSearch(7));
//        System.out.println(unionFind.unionSearch(9));

//        System.out.println(unionFind.unionSearch(11));
//        System.out.println(unionFind.unionSearch(11));

//        System.out.println(unionFind.isConnected(5, 9));
        System.out.println(unionFind.unionSearch(9));
        unionFind.join(5, 9);
        System.out.println(unionFind.isConnected(5, 9));
    }
}
