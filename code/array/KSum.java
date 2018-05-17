package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 计算k个数字的和等于target
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/1
 * @Description:
 */
public class KSum {

    public static void main(String[] args) {

        int[] s = {-1,0,1,2,-1,-4};
        int target = -1;
        int k = 4;
        KSum kSum = new KSum();
        List<List<Integer>> lists = kSum.kSum(s,target,k);
        for(List<Integer> list : lists)
            System.out.println(list);

    }

    public List<List<Integer>> kSum(int[] nums,int target,int k){

        List<List<Integer>> lists = new ArrayList<>();

        //对于大小 < k 的数组，直接返回
        if(nums.length < k)
            return lists;

        Arrays.sort(nums);

        //递归，降阶，直到为2
        //中间可以加入一些判断
        return kSum_reduce(nums,target,k,0);

    }

    /**
     * 降阶，递归计算结果
     * @param nums
     * @param target
     * @param k
     * @param startIndex
     * @return
     */
    private List<List<Integer>> kSum_reduce(int[] nums,int target,int k,int startIndex){

        if(k == 2)
            return twoSum(nums,startIndex,target);
        else{

            List<List<Integer>> lists = new ArrayList<>();
            for(int i=startIndex;i<= nums.length - k;i++){

                if(i > startIndex && nums[i] == nums[i-1])
                    continue;

                //计算降阶之后需要计算的值
                int reducedTarget = target - nums[i];

                //降阶，递归计算
                List<List<Integer>> reducedList = kSum_reduce(nums,reducedTarget,k-1,i+1);
                //合并结果
                for(List<Integer> list : reducedList){
                    list.add(0,nums[i]);
                    lists.add(list);
                }

            }

            return lists;
        }

    }

    //在有序数组中找出符合条件的元素
    private List<List<Integer>> twoSum(int[] nums,int startIndex,int target){

        List<List<Integer>> lists = new ArrayList<>();
        int j=startIndex, k=nums.length -1;

        while(j<k){

            int sum = nums[j] + nums[k];
            if(sum == target){
                List<Integer> list = new LinkedList<Integer>();
                list.add(nums[j]);
                list.add(nums[k]);

                lists.add(list);
                while(j < k && nums[j] == nums[j+1])
                    j++;
                while(j<k && nums[k] == nums[k-1])
                    k--;
                j++;
                k--;
            }

            else if(sum > target)
                k--;
            else
                j++;

        }

        return lists;

    }

}
