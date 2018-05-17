package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/21
 * @Description:
 */
public class HeapSort2 {

    public static void main(String[] args){

        int[] a = {4,1,3,2,16,9,10,14,8,7};
//        buildMaxHeap(a);
        heapSort(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);

    }


    public static int parent(int i){
        int parent = (i -1)/2;
        return parent;
    }

    public static int leftChild(int i){
        int leftChild = 2*i +1;
        return leftChild;
    }

    public static int rightChild(int i){
        int rightChild = 2*(i +1);
        return rightChild;
    }

    /**
     * 维护以某个节点为根节点的最大堆性质
     * @param a
     * @param i
     */
    public static void maxHeapify(int[] a,int i){

        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        int largest = i;

        if(leftChild < a.length && a[leftChild] > a[i]){
            largest = leftChild;
        }

        if(rightChild < a.length && a[rightChild] > a[largest]){
            largest = rightChild;
        }

        if(largest != i){
            //将a[i]与子节点进行交换
            int max = a[largest];
            a[largest] = a[i];
            a[i] = max;

            //交换之后，需要保证被交换的子树还能有最大堆性质
            maxHeapify(a,largest);
        }
    }

    public static void maxHeapify(int[] a,int i,int heapSize){

        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        int largest = i;

        if (leftChild < heapSize && a[leftChild] > a[largest]){
            largest = leftChild;
        }

        if(rightChild < heapSize && a[rightChild] > a[largest]){
            largest = rightChild;
        }

        if(largest != i){

            int max = a[largest];
            a[largest] = a[i];
            a[i] = max;
            maxHeapify(a,largest,heapSize);
        }

    }

    /**
     * 构造大顶堆
     * @param a
     */
    public static void buildMaxHeap(int[] a){

        for(int i = (a.length-1)/2;i >= 0;i--)
            maxHeapify(a,i);

    }

    /**
     * 进行堆排序，将数组从小到大进行排序
     * @param a
     */
    public static void heapSort(int[] a){

        //先构造一个大顶堆，然后将大顶堆的最大值与数组末尾的值进行交换
        //这时就得到了一个子节点符合最大堆性质，但是根节点不符合最大堆性质的树
        //这时将堆的大小减小，对剩余的部分进行排序
        buildMaxHeap(a);
        for(int i=a.length-1;i >= 1;i--){

            //将a[0]与a[i]进行交换
            int max = a[i];
            a[i] = a[0];
            a[0] = max;
            maxHeapify(a,0,i);
        }

    }

}
