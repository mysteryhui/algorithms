package dp;

/**
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4]
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 dp[i] = max{dp[i-1], 经过a[i]的连续子串}

 sum , tmpSum , nums[i]


 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/15
 * @Description:
 */
public class MaximumSubarray {

    public static void main(String[] args) {

//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {8,-19,5,-4,20};
        int sum = maxSubArray(nums);
        System.out.println(sum);

    }

    public static int maxSubArray(int[] nums) {

        if(nums.length < 2)
            return nums[0];

        int sum = nums[0];
        int tmpSum = nums[0];

        int[] sums = new int[nums.length];

        for(int i=1;i<nums.length;i++){

            tmpSum += nums[i];

            if(tmpSum > sum)
                sum = tmpSum;

            if(sum < nums[i]){
                sum = nums[i];
                tmpSum = nums[i];
            }

            if(tmpSum < 0)
                tmpSum = 0;

            System.out.print("element : " + nums[i]);
            System.out.print(" , tmpSum : " + tmpSum);
            System.out.print(" , sum : " + sum);
            System.out.println();

        }

        return sum;
    }

}
