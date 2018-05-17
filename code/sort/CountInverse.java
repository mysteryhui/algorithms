package sort;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/9
 * @Description: 查找有n个元素的数组中的逆序对的数量
 * 问题描述：
 *      逆序对： 对于数组a,有 数组下标i，j，如果i < j , 同时 a[i] > a[j]，则称( a[i],a[j] ) 为一个逆序对
 *      例如对于数组：{2,3,8,6,1}
 *      有逆序对如下：(2,1) , (3,1), (8,1) , (8,6) (6,1)
 *
 * 解题思路：
 *      使用归并排序来解决问题。
 *      对于归并排序中进行合并时，需要比较左右两边数组，这时如果a[i] > a[j] ，
 *      因为a[i]为左边最小的数，所以从a[i]到左边数组的结束，都是逆序对。
 *
 */
public class CountInverse {

    static int num = 0;


    public static void main(String[] args){

    }

    /**
     * 计算一个数组中逆序对的个数
     * @param array
     */
    public void count(int[] array,int left,int right){

        if(left < right){

            int mid = (left + right) /2;
            count(array,left,mid);
            count(array,mid+1,right);
            merge(array,left,mid,right);

        }

    }

    public void merge(int[] array,int left,int mid,int right){

            int leftLength = mid - left+1;
            int rightLength = right - mid;

            int[] leftArray = new int[leftLength];
            int[] rightArray = new int[rightLength];

            for(int i=0;i<leftLength;i++){
                leftArray[i] = array[left + i];
            }

            for(int i=0;i<rightLength;i++){
                rightArray[i] = array[right + i];
            }

            //合并数组
            int i = 0, j = 0,k=0;
            while( i < leftArray.length && j < rightArray.length ){
                if(array[i] > array[j]){
                    num += mid - left +1;
                    array[k++] = array[j];
                    j++;
                }else{
                    array[k++] = array[i];
                    i++;
                }

            }

            while (i < leftLength)
                array[k++] = leftArray[i++];

            while (j < rightArray.length)
                array[k++] = leftArray[j++];

    }


}
