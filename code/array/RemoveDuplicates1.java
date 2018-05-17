package array;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/26
 * @Description:
 *
 *  从一个排好序的数组中移除重复的元素
 *
 */
public class RemoveDuplicates1 {

    public static void main(String[] args){

        int[] nums = {1,1,1,2,2,2,2,3,3,3,4};
        int length = removeDuplicates(nums);
        System.out.println("length : " + length);

        for(int i=0;i<length;i++){

            System.out.println(nums[i]);

        }

    }

    public static int removeDuplicates(int[] nums){

        //当元素个数小于3时，直接返回
        if(nums.length < 3){
            return nums.length;
        }

        int i=2,j=1;
        for(;i<nums.length;i++){

            if(nums[i] != nums[j] || nums[i] != nums[j-1] )
                nums[++j] = nums[i];
        }

        return j+1;

    }

}
