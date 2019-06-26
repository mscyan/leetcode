package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.zip.Adler32;

/**
 * 数组实现大根堆
 */
public class ArrayHeap {

    private int size;
    private int capacity;
    private int[] root;

    public ArrayHeap() {
        this(5);
    }

    public ArrayHeap(int capacity) {
        if (capacity < 1) {
            capacity = 5;
        }
        this.capacity = capacity;
        this.size = 0;
        root = new int[capacity];
    }

    public void insert(int num) {
        if (this.size == this.capacity) {
            //扩容
        } else {
            root[size] = num;
            size++;
            for (int i = size / 2; i >= 0; i--) {
                adjustHeap(root, i, size);
            }
        }
    }

    public int top() {
        if (size > 0) {
            return root[0];
        }
        return -1;
    }

    public void pop() {

    }

    /**
     * 堆排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param num_array 待排序的堆
     */
    public void HeapSort(int[] num_array) {
        if(num_array == null || num_array.length <= 1){
            return;
        }
        //堆排序实现；
        //需要注意的是下标， 若数组长度为n，则下标范围为 0~(n-1)，
        // 那么最后一个非叶子节点的下标为 (n-2)/2，从该位置自底向上遍历节点并维护堆的状态
        // 就可以将大值交换到根节点。
        int len = num_array.length;
        buildHeap(num_array, len-1);
        ///***该循环时间复杂度为 n ***///
        for (int i = len - 1; i > 0; i--) {
            int temp = num_array[i];
            num_array[i] = num_array[0];
            num_array[0] = temp;

            adjustHeap(num_array, 0, i-1);
        }
    }

    public void buildHeap(int[] array, int heapSize){
        for(int i=(heapSize-1)/2; i>=0; i--){
            adjustHeap(array, i, heapSize);
        }
    }

    /**
     * 堆调整：维护堆状态至 符合大根堆的性质
     *
     * @param t_array 待排序的堆
     * @param index   从该节点依次向上调整堆状态
     * @param limit  需要调整的堆的长度
     */
    private void adjustHeap(int[] t_array, int index, int limit) {
        //调整堆的状态
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int max = -1;
        if(left <= limit && t_array[left]>t_array[index]){
            max = left;
        }
        else{
            max = index;
        }
        if(right <= limit && t_array[right]>t_array[max]){
            max = right;
        }
        if(max != index){
            int temp = t_array[max];
            t_array[max] = t_array[index];
            t_array[index] = temp;
            adjustHeap(t_array, max, limit);
        }
    }

    public static void main(String[] args) {
        //
        ArrayHeap heap = new ArrayHeap(10);
        int[] a = {4, 1, 66, 23, 7, 192, 6, 12, 91, 45, 2, 19, 81, 3, 5, 123, 8, 1221, 9};
        heap.HeapSort(a);

        System.out.println(Arrays.toString(a));
    }
}
