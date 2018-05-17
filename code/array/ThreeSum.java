package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/27
 * @Description:
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {

    public static void main(String[] args){

        int[] nums = {-1, 0, 1, 2, 2, 2, -1, -1, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for(List<Integer> list : lists){
            System.out.println(list.toString());
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        //因为数组是已经排序的，所以只需要将遍历一遍数组，同时在第二遍时，找另外两个数字
        for(int i=0;i<nums.length-2;i++){

            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int targetNum = -nums[i];
            //剩余的计算方式就是和two sum题目中一样，使用两端逼近的方法
            int j = i+1,k = nums.length-1;
            while(j < k){

                int computeNum = nums[j] + nums[k];
                if( computeNum == targetNum){
                    //需要增加去重判断，对于数组中元素全部一致的情况
                    lists.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j < k && nums[j] == nums[j+1])
                        j++;
                    while(j<k && nums[k] == nums[k-1])
                        k--;
                    j++;
                    k--;
                }else if(computeNum > targetNum)
                    k--;
                else
                    j++;

            }

        }

        return lists;
    }

}
