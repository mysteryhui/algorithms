package divideAndConquer;

/**
 * @Author : wanghui
 * @Date : create on 2017/10/30
 * @Description: 最大子数组问题
 *
 * 问题描述：
 *  给定一个数组，求最大的非空连续子数组
 *
 * 解决思路：
 *  使用分治法来求解最大子数组，使用分治的法的核心思想就是分解、合并，其中合并是算法的核心；
 *  对于最大子数组问题，通过分治来解决的步骤如下：
 *      1. 将数组的规模减小，直到数组的大小为1，这时求解的复杂度为O(1)；
 *      2. 将规模为1的子问题，进行合并，可以求解出规模更大的问题；
 *      3. 递归调用合并，直接问题的规模从1合并到n；
 *
 * 求解最大子数组的思路：
 *      1. 对于求解一个数组的最大子数组，我们可以将数组等分成两份，即为：A[1...mid],A[mid+1....n], mid = n/2
 *      2. 对于分解后的数组，最大子数组只可能存在于A[1..mid],A[mid+1...n]或A[.. mid ..]两个数组中间； 将问题分解为互斥的子问题
 *      3. 对于求位于中间的最大子数组，可以先求出A[left,mid]即左边的最大值，然后再求出A[mid+1,right]的最大值，
 *          然后对这个两个数组求和，即可求解位于中间的最大子数组；
 *      4. 这时问题就可以转换为，求出左边数组的最大子数组，求出右边的最大子数组，求出中间最大子数组，然后比较大小，将最终结果最大的数组返回；
 *
 *
 *
 */
public class MaxSubArray {

    public static void main(String[] args){

        int[] array = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        RstSubArray rstSubArray = maxSubArray(array,0,array.length -1);
        System.out.println(rstSubArray);

    }

    /**
     * 计算数组的某个区间的最大连续非空子数组
     * @param array
     * @param left
     * @param right
     */
    public static RstSubArray maxSubArray(int[] array,int left,int right){

        //递归结束的条件，当规模等于1时，递归结束
        if(left == right){
            return new RstSubArray(array[left],left,right);
        }

        int mid = (left + right)/2;
        //递归求解左边的最大连续非空子数组
        RstSubArray leftSubArray = maxSubArray(array,left,mid);

        //求解中间的最大非空连续子数组
        RstSubArray rightSubArray = maxMidArray(array,left,mid,right);

        //递归求解右边的最大连续非空子数组
        RstSubArray midSubArray = maxSubArray(array,mid+1,right);

        //最后比较三个数组的大小，返回值最大的数组
        if(leftSubArray.maxSubArraySum >= rightSubArray.maxSubArraySum
                && leftSubArray.maxSubArraySum >= midSubArray.maxSubArraySum){

            return leftSubArray;
        }else if(rightSubArray.maxSubArraySum >= midSubArray.maxSubArraySum){
            return rightSubArray;
        }else {
            return midSubArray;
        }

    }

    /**
     * 求解一个数组的位于中间的最大子数组
     * @param array
     * @param left
     * @param right
     * @return      返回最大中间连续子数组的和，左边索引，右边索引
     */
    public static RstSubArray maxMidArray(int[] array,int left,int mid,int right){

        //求出左边最大子数组
        int maxLeftSum = Integer.MIN_VALUE;
        int leftSum = 0 ;
        int maxLeftIndex = mid;
        for(int i = mid;i >= left;i--){

            leftSum += array[i];
            if(leftSum > maxLeftSum){
                maxLeftSum = leftSum;
                maxLeftIndex = i ; //记录最大值的下标
            }

        }

        //求出右边最大子数组
        int maxRightSum = Integer.MIN_VALUE;
        int rightSum = 0;
        int maxRightIndex = mid + 1;
        for(int i = mid + 1; i <= right;i++){

            rightSum += array[i];
            if(rightSum > maxRightSum){
                maxRightSum = rightSum;
                maxRightIndex = i;
            }

        }

        //求出最大中间子数组，因为是中间子数组，所以必须是左边 + 右边（即数组时穿过中间元素的），否则就是单边最大的子数组的子集了
        int maxMidSum = maxLeftSum + maxRightSum;
        RstSubArray rstSubArray = new RstSubArray(maxMidSum,maxLeftIndex,maxRightIndex);

        return rstSubArray;
    }


}

class RstSubArray{

    int maxSubArraySum;
    int maxLeft;
    int maxRight;

    RstSubArray(){

    }

    RstSubArray(int maxSubArraySum,int maxLeft,int maxRight){
        this.maxSubArraySum = maxSubArraySum;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
    }

    @Override
    public String toString() {
        return "RstSubArray{" +
                "maxSubArraySum=" + maxSubArraySum +
                ", maxLeft=" + maxLeft +
                ", maxRight=" + maxRight +
                '}';
    }
}
