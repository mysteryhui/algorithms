package sort;

import java.util.Collections;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/22
 * @Description: 最小堆实现的优先队列
 */
public class MinHeap {

    public int[] a;
    private int heapSize = 0;

    public static void main(String[] args){

        int[] b = {4,1,3,2,16,9,10,14,8,7};
        MinHeap minHeap = new MinHeap();
//        minHeap.buildMinHeap(b);
        minHeap.buildMinHeap2(b);
        for(int i=0;i<b.length;i++)
            System.out.println(minHeap.a[i]);

//        Collections.sort();

    }

    public MinHeap(){
        a = new int[10];
    }

    public MinHeap(int maxSize){
        a = new int[maxSize];
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    /**
     * 以节点i为根节点，构造一个符合最小堆性质的数组
     * @param a
     * @param i
     */
    private void minHeapify(int[] a, int i){

        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left < heapSize && a[left] < a[smallest]){
            smallest = left;
        }

        if(right < heapSize && a[right] < a[smallest]){
            smallest = right;
        }

        if(smallest != i){

            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            minHeapify(a,smallest);
        }

    }

    /**
     * 构造一个最小堆
     * @param b
     */
    public void buildMinHeap(int[] b){
        heapSize = a.length;

        for(int i = heapSize/2 - 1;i >= 0;i--)
            minHeapify(b,i);

    }

    /**
     * 返回最小值
     * @param a
     * @return
     */
    private int minimum(int[] a){

        return a[0];
    }

    /**
     * 返回最小值，并将最小值剔除
     * @param a
     */
    private int extractMin(int[] a){

        int min = a[0];
        a[0] = a[heapSize-1];
        a[heapSize-1] = min;
        heapSize--;
        minHeapify(a,0);

        return min;
    }

    /**
     * 将某个节点i的值减小到k
     * @param a
     * @param i
     * @param k
     */
    private void decreaseKey(int[] a,int i,int k){

        if(a[i] < k)
            return ;

        a[i] = k;
        int parent = parent(i);
        while(i > 0 && a[parent] > a[i]){

            int temp = a[i];
            a[i] = a[parent];
            a[parent] = temp;

            i = parent(i);
        }

    }

    /**
     * 向当前队列中插入一个key值为s的节点
     * @param a
     * @param s
     */
    private void insert(int[] a,int s){

        heapSize++;
        if(heapSize > a.length){
            //需要对现有的数组进行扩容
            //由于存在扩容操作，所以需要加锁,同时对于插入或者去除操作都需要相应加锁
            int newLength = 2*a.length + 1;
            int[] b = new int[newLength];
            System.arraycopy(a,0,b,0,a.length);
            a = b;
        }

        a[heapSize-1] = Integer.MAX_VALUE;
        decreaseKey(a,heapSize-1,s);

    }

    public void buildMinHeap2(int[] b){

        heapSize = 0;
        for(int i=0;i<b.length;i++){

            insert(a,b[i]);

        }

    }



}
