package dp;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/26
 * @Description: 最大乘积的子数组
 */
public class MaxProductSub {

    public static void main(String[] args) {

//        int[] nums = {2,3,-2,4};
//        int[] nums = {-2,0,-1,-2};
//        int[] nums = {3, -1, 4};
        int[] nums = {2,-5,-2,-4,3};
        int max = maxProduct(nums);
        System.out.println(max);

    }

    public static int maxProduct(int[] nums) {


        int sum = 1;
        int maxMinus = -1;                       //最小值，负数
        int maxPositive = Integer.MIN_VALUE;    //最大值，正数

        for(int num : nums){

            sum = sum * num;
            if(sum < 0){
                maxMinus = Math.min(maxMinus, sum);
            }else if(sum > 0) {
                maxPositive = Math.max(maxPositive, sum);
            }else
                sum = 1;

        }

        return maxPositive;
    }

}
