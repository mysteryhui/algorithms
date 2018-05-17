package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/26
 * @Description: 快速排序
 *
 *  快速排序，是一个原址排序，它也采用了分治的思想，分治的核心就是合并的部分,实现起来比堆排序要简单
 *
 */
public class QuickSort {

    public static void main(String[] args){

        int[] a = {5,2,3,5,6,8,1,0,9};
        int[] b = {5,5,5,5,5,5,5,5};
//        quickSort(a,0,a.length-1);
//        quickSortAsc(b,0,b.length-1);
        quickSortDesc(a,0,a.length-1);
        for(int i:a)
            System.out.println(i);
    }


    public static void quickSortAsc(int[] a,int l,int r){

        if(l < r){
            //对于数组长度大于1的数组进行排序
            //将数组进行分割，分割成两个部分，左边的部分都比q小，右边的部分都比q大
            int q = partitionAsc(a,l,r);
            System.out.println("q : " + q);
            //对剩余的数组继续进行排序
            quickSortAsc(a,l,q-1);
            quickSortAsc(a,q+1,r);
        }

    }

    public static int partitionAsc(int[] a,int l,int r){

        //选择最右边的值作为标准值进行排序
        int value = a[r];
        int lessIndex = l-1; //存储比标准值小的值的下标
        for(int i=l;i < r; i++){

            if(a[i] <= value ){
                //如果a[i]的值小于a[r]，则将a[i]与a[++lessIndex]进行交换
                lessIndex++;
                exchange(a,lessIndex,i);
            }

        }
        //循环结束时，小于等于lessIndex的数组元素都是小于a[r[的，
        //最后需要将a[r]的值与a[++lessIndex]进行交换即可
        //这样lessIndex左边的值都比lessIndex小，右边都大于等于它
        lessIndex++;
        exchange(a,lessIndex,r);

        return lessIndex;
    }

    public static void exchange(int[] a,int i,int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void quickSortDesc(int[] a,int l,int r){

        if(l < r){
            int q = partitionDesc(a,l,r);
            quickSortDesc(a,l,q-1);
            quickSortDesc(a,q+1,r);
        }
    }

    public static int partitionDesc(int[] a,int l,int r){

        int value = a[r];
        int moreIndex = l-1;    //使左边的数都比a[r]大
        for(int i=l;i< r;i++){

            if(a[i] >= value)
                exchange(a,++moreIndex,i);

        }
        //循环结束之后，交换a[r]与a[++moreIndex]
        exchange(a,++moreIndex,r);
        return moreIndex;
    }

}
