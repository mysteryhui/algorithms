package array;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/7
 * @Description:
 */
public class SearchRange {

    public static void main(String[] args) {

        SearchRange searchRange = new SearchRange();
        int[] nums = {2};
        int[] index = searchRange.searchRange(nums,2);
        System.out.println(index[0] + ", " + index[1]);

    }

    /**
     * 使用两次二分法，第一次二分找到左边界，第二次二分找到右边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int[] targetIndex = {-1,-1};

        if(nums.length == 0)
            return targetIndex;

        int left = 0,right = nums.length - 1;

        //找出左边界
        while(left <= right){

            int mid = left + (right - left)/2;
            if(nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;

        }
        System.out.println("left : " + left);

        if(left >nums.length-1 || nums[left] != target)
            return targetIndex;

        targetIndex[0] = left;
        right = nums.length - 1;
        while(left <= right){

            int mid = left + (right - left)/2;
            if(nums[mid] <= target)
                left = mid +1;
            else
                right = mid - 1;

        }
        System.out.println("right : " + right);
        targetIndex[1] = right;

        return targetIndex;
    }

}
