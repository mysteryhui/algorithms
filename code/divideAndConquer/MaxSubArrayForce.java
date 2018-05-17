package divideAndConquer;

/**
 * @Author : wanghui
 * @Date : create on 2017/10/31
 * @Description: 暴力法求解 最大子数组问题
 */
public class MaxSubArrayForce {


    public static void main(String[] args){

        int[] array = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        maxSubArrayBruteForce(array,0,array.length-1);

    }

    public static void maxSubArrayBruteForce(int[] array,int left,int right){

        int maxSubSum = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;

        //使用暴力枚举法，将每个连续数组的值计算出来
        for(int i=left;i<= right;i++){

            int sum = 0;
            for(int j=i;j<= right;j++){
                //计算以i开头的最大连续数组
                sum += array[j];
                //计算当前数组的值是否大于当前最大的子数组的和，如果大于，就将当前的子数组作为最大子数组
                if(sum > maxSubSum){
                    maxSubSum = sum;
                    maxLeft = i;
                    maxRight = j;
                }

            }

        }
        System.out.println("maxLeft   : " + maxLeft);
        System.out.println("maxRight  : " + maxRight);
        System.out.println("maxSubSUm : " + maxSubSum);

    }

}
