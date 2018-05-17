package array;

/**
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Input: [1,3,5,6], 5
 *
 * Output: 2
 *
 *
 * Input: [1,3,5,6], 2
 *
 * Output: 1
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition position = new SearchInsertPosition();
        int[] nums = {};
        int index = position.searchInsert(nums,7);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {

        if(nums.length == 0)
            return 0;

        int left = 0,right = nums.length -1;

        while(left <= right){

            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else
                return mid;

        }

        return left;

    }

}
