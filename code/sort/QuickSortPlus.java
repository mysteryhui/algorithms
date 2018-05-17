package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/28
 * @Description: 优化版快排
 *
 * 对于数组中有重复元素时，进行优化
 *
 */
public class QuickSortPlus {


    public static void quickSort(int[] a,int l,int r){

    }

    /**
     * 部分排序 ，对于i < q, 有a[i] < a[q]，对于i > t , a[i] > a[t]， 对于 a[q]和a[t]中的元素都是相等的
     * @param a
     * @param l
     * @param r
     * @return
     */
    public static int[] partition(int[] a,int l,int r){

        int q,t;
        int compVal = a[r];
        int minIndex = l-1;
        int equalIndex = r;
        for(int j=l;j < equalIndex;){

//            if(a[j] < compVal)


        }




        return null;

    }


}
