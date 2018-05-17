package array;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/26
 * @Description:
 */
public class MergeSortArray {

    public static void main(String[] args){

        int[] nums1 = {1,0,0,0,0,0};
        int[] nums2 = {0};
        int m = 1,n=0;
        merge(nums1,m,nums2,n);
        for(int i=0;i<m+n;i++)
            System.out.println(nums1[i]);

    }

    /**
     * 对数组nums1和nums2进行归并,归并的结果放到nums1中
     * 由于在nums1中进行排序，所以只需要从尾部开始遍历
     * 归并排序的核心算法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        int i = m+n-1,j = m-1,k=n-1;
        while (j >= 0 && k >= 0){

            if(nums1[j] > nums2[k]){
                //将最大值复制给nums1[i]
                nums1[i--] = nums1[j--];
            }else{
                nums1[i--] = nums2[k--];
            }

        }

        if(k + 1 > 0){
            //当k>0时，需要将nums2中0-k的元素全部复制到nums1中
            //因为k表示下标，所以复制的时候需要将k+1
            System.arraycopy(nums2,0,nums1,0,k+1);
        }

        //当j>0时，因为数组已经在j中了，所以不需要再从复制

    }

}
