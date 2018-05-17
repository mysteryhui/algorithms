package sort;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/16
 * @Description: 给定一个数组，只有3个值，0，1，2，按照顺序对数组进行排序
 */
public class SortColors {

    public static void main(String[] args) {

        int[] num = {1,0};
        sortColors(num);
    }

    public static void sortColors(int[] nums) {

        //只有两个值的情况下，可以使用快速排序
        int j = -1;
        for(int i=0; i<nums.length; i++){

            if(nums[i] == 0){

                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }

        }

        // 小于等于j的元素全是0，对剩余元素再次进行快排
        for(int i=j+1; i<nums.length; i++){

            if(nums[i] == 1){

                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

    }

}
