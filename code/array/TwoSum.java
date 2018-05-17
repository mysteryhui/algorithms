package array;

import java.util.HashMap;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/27
 * @Description:
 *
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 *
 */
public class TwoSum {

    public static void main(String[] args){

        int[] nums = {2, 7, 11, 15};
        int[] targetIndex = twoSum(nums,9);
        for(int index : targetIndex)
            System.out.println(index);

        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        map.put(11,10);
        Integer i = map.get(10);
        System.out.println(i);

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        //遍历两遍，第一遍将数组放到map中
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        //第二遍遍历，根据key找到value
        int[] targetIndex = new int[2];
        for(int i = 0;i<nums.length;i++){
            int another = target - nums[i];
            if(!map.containsKey(another))
                continue;

            int anotherIndex = map.get(another);
            if(anotherIndex != i){
                targetIndex[0] = i;
                targetIndex[1] = anotherIndex;
                break;
            }

        }

        return targetIndex;
    }

}
