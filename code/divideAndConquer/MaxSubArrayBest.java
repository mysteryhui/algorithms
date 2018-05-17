package divideAndConquer;

/**
 * @Author : wanghui
 * @Date : create on 2017/11/2
 * @Description: 实现线性复杂度的求解最大子数组的算法
 */
public class MaxSubArrayBest {


    public static void maxSubArray(int[] array,int left,int right){

        int bestLeftSum = Integer.MIN_VALUE;
        int leftIndex = left;
        int rightIndex = left;

        for(int i=left;i <= right;i++){



        }


    }

    public static void maxRightArray(int[] array,int left,int right){

        int maxSum = Integer.MIN_VALUE;
        int leftIndex = right;
        int rightSum = 0;

        for(int i=right;i>=left;i--){
            rightSum += array[i];


        }

    }

}
