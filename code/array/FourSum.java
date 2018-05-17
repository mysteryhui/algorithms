package array;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/1
 * @Description:
 */
public class FourSum {

    public static void main(String[] args) {

        int[] s = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> lists = fourSum(s,target);

        for(List<Integer> list : lists)
            System.out.println(list.toString());

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        if(nums.length < 4)
            return lists;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){

            if(i > 0 && nums[i] == nums[i-1])
                continue;

            for(int j=i+1;j<nums.length-2;j++){

                if(j > i+1 && nums[j] == nums[j-1])
                    continue;

                int p = j+1,q = nums.length-1;
                while(p < q){

                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if(sum == target){

                        lists.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                        while(p < q && nums[p] == nums[p+1])
                            p++;
                        while(p < q && nums[q] == nums[q-1])
                            q--;

                        p++;
                        q--;

                    }else if(sum > target)
                        q--;
                    else
                        p++;

                }

            }

        }

        return lists;

    }

    public List<List<Integer>> fourSumI(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            if(nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target)continue;
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[n-2]+nums[n-1]<target) continue;
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int low = j+1, high = n-1;
                while(low<high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1])low++;
                        while(low<high && nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target) low++;
                    else high--;
                }
            }
        }
        return res;

    }

}
