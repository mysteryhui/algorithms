package array;


/**
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/1
 * @Description:
 */
public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums = {-3,-2,-5,3,-4};
        int target = -1;

        int closestSum = threeSumClosest(nums,target);
        System.out.println(closestSum);

    }

    public static int threeSumClosest(int[] nums, int target) {

        if(nums.length < 3)
            return 0;

        //排序
        Arrays.sort(nums);

        Integer lastSum = null;

        //
        for(int i=0;i < nums.length-2;i++){

            int j = i+1,k = nums.length -1;

            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];

                //因为只有一个解，所以直接返回即可
                if(sum - target == 0)
                    return sum;
                else if(sum - target > 0)
                    k--;
                else
                    j++;

                //比较上一个sum的值和本次sum的值，将接近target的值存入lastSum中
                if(lastSum == null){
                    lastSum = sum;
                }else if(Math.abs(lastSum-target) > Math.abs(sum-target)){
                    lastSum = sum;
                }

            }

        }

        return lastSum;

    }

}
