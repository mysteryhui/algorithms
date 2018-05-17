package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/21
 * @Description: 优先队列
 */
public class PriorityQueue {


    public static int heapSize = 0;


    public static void main(String[] args){

        int[] a = new int[20];
        insert(a,10);
        insert(a,12);
        insert(a,13);
        insert(a,9);
        insert(a,11);
        insert(a,15);

        for(int i=0;i<heapSize;i++){
            System.out.println(a[i]);
        }

    }

    public static void insert(int[] a,int s){

        heapSize++;
        a[heapSize] = Integer.MIN_VALUE;
        increaseKey(a,heapSize-1,s);

    }

    public static int maximum(int[] a){
        return a[0];
    }

    public static int extractMax(int[] a){
        int max = a[0];
        a[0] = a[a.length-1];
        a[a.length-1] = max;

        HeapSort2.maxHeapify(a,0,heapSize);

        return max;

    }

    /**
     * 关键方法
     * @param a
     * @param i
     * @param k
     */
    public static void increaseKey(int[] a,int i,int k){

        if(k < a[i])
            return;

        int parent = HeapSort2.parent(i);
        a[i] = k;
        while(i > 0 && a[parent] < a[i]){

            int temp = a[i];
            a[i] = a[parent];
            a[parent] = temp;

            i = parent;
            parent = HeapSort2.parent(i);

        }

    }

}
