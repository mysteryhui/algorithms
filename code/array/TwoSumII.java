package array;

/**
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

import java.util.Collection;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/28
 * @Description:
 *      在没有排序的情况，可以直接使用hashMap进行一次遍历，找出索引
 *      现在对于有排序的情况，就简单的多了，因为是已经排序的情况，所以使用两个指针i,j来进行前后遍历
 *
 *      A[i] + A[j] = target , 返回 i,j
 *      A[i] + A[j] > target , 因为和比较大，所以i++是没有意义的，这时只需要 j--
 *      A[i] + A[j] < target , 因为和比较小，所以增加i,i++
 *
 */
public class TwoSumII {

    public static void main(String[] args){

        int[] numbers = {2, 7, 11, 15};
        int[] indexes = twoSum(numbers,9);
        for(int index : indexes)
            System.out.println(index);
    }

    public static int[] twoSum(int[] numbers, int target) {

        if(numbers.length < 2)
            return null;

        int[] indexes = new int[2];
        for(int i = 0,j=numbers.length-1;i < j;){

            int sum = numbers[i] + numbers[j];
            if(sum == target){
                indexes[0] = i+1;
                indexes[1] = j+1;
                break;
            }else if( sum > target)
                j--;
            else
                i++;

        }

        return indexes;
    }

}
