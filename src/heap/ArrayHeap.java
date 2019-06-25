package heap;

public class ArrayHeap {

    private int size;
    private int capacity;
    private int[] root;

    public ArrayHeap(){
        this(5);
    }

    public ArrayHeap(int capacity){
        if(capacity < 1){
            capacity = 5;
        }
        this.capacity = capacity;
        this.size = 0;
        root = new int[capacity];
    }

    public void insert(int num){
        if(this.size == this.capacity){
            //扩容
        }
        else{
            root[size] = num;
            size++;
            for(int i=size-1;i>=0;i--){
                adjustHeap(i);
            }
        }
    }

    public int top(){
        if(size > 0){
            return root[0];
        }
        return -1;
    }

    public void pop(){

    }

    private void adjustHeap(int index){
        //调整堆的状态
        int left = index*2 + 1;
        int right = index*2 + 2;
        if(left <= size - 1){
            if(root[index] < root[left]){
                int t = root[index];
                root[index] = root[left];
                root[left] = t;
            }
        }
        if(right <= size - 1){
            if(root[index] < root[right]){
                int t = root[index];
                root[index] = root[right];
                root[right] = t;
            }
        }
    }

    public static void main(String[] args){
        //
        ArrayHeap heap = new ArrayHeap(10);
        heap.insert(50);
        heap.insert(23);
        heap.insert(12);
        heap.insert(43);
        heap.insert(91);
        heap.insert(129);
        heap.insert(78);
        heap.insert(131);

        System.out.println(heap.top());
    }
}
