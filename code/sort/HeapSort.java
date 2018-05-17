package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/20
 * @Description: 堆排序 , 使用的数组下标从1开始
 *
 * 给定一个数组a[i],将数组进行排序
 *
 */
public class HeapSort {

    public static void main(String[] args){

        int[] a = {-1,4,1,3,2,16,9,10,14,8,7};
        buildMaxHeap(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);

    }


    /**
     * 返回某个节点的父节点索引
     * @param i
     * @return
     */
    public static int parentIndex(int i){

        int parentIndex = i/2;
        return parentIndex;
    }

    /**
     * 返回当前节点的左子节点的下标
     * @param i
     * @return
     */
    public static int leftChildIndex(int i){

        int childIndex = 2*i;
        return childIndex;
    }

    /**
     * 返回当前节点的右子节点的下标
     * @param i
     * @return
     */
    public static int rightChildIndex(int i){
        int childIndex = 2*i +1;
        return childIndex;
    }

    /**
     * 维护最大堆性质
     * 前提：
     *  节点i的子节点都是符合最大堆性质；
     *
     * @param a
     * @param i
     */
    public static void maxHeapify(int[] a, int i){

        int leftChild = leftChildIndex(i);
        int rightChild = rightChildIndex(i);
        int largest = i;

        if(leftChild < a.length && a[leftChild] > a[i]){
            largest = leftChild;
        }

        if(rightChild < a.length && a[rightChild] > a[largest]){
            largest = rightChild;
        }

        if(largest != i){
            //交换a[i]和a[largest]的值
            int max = a[largest];
            a[largest] = a[i];
            a[i] = max;

            //由于根节点的值和子节点的值进行了交换，所以就破坏了子树的最大堆性质
            //这是就需要对子树进行最大堆性质的维护
            maxHeapify(a,largest);
        }

    }

    /**
     * 将给定的数组构造成符合最大堆性质的数组
     * 可以采用自底向上的方式，将从最下层非叶子节点开始，对数组进行维护
     *
     * @param a
     */
    public static void buildMaxHeap(int[] a){

        //由于一个数组的叶子节点下标必定为: n/2 +1 ..... n
        //同时由于叶子节点已经符合最大堆性质了，所以只需要从最低部的非叶子节点开始递归维护最大堆性质即可
        for(int i = a.length/2;i > 0;i--)
            maxHeapify(a,i);

    }



}
