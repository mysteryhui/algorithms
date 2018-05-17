package array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */

import javax.sound.midi.MidiChannel;
import java.nio.charset.Charset;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/2
 * @Description:
 */
public class FindMin {

    public static void main(String[] args) {

        int[] s = {3,1,3};
        FindMin findMin = new FindMin();
//        System.out.println(findMin.findMinByHeap(s));
        System.out.println(findMin.findMin(s));


    }

    /**
     *
     * 使用二分法来查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        //先排除没有旋转的情况
        if(nums[left] < nums[right])
            return nums[0];

        //根据二分法找到元素
        int mid = (left + right)/2 ;
        while ( mid > left && mid < right ){
            if(nums[mid] < nums[right])
                right = mid;
            else if(nums[mid] > nums[right])
                left = mid;
            else
                right = right -1;

            mid = (left + right)/2;
        }

        return nums[right];
    }

    /**
     * 对于无序的数组，可以构造一个小顶堆，来得到最小值
     * @param nums
     * @return
     */
    public int findMinByHeap(int[] nums){
        createMinHeap(nums);
        return nums[0];
    }

    /**
     * 构造一个最小堆
     *
     * 最小堆的性质是，堆中顶点的值比左右子节点都小
     *
     * 完全二叉树性质(数组长度为n):
     *     1. 叶子节点的下标为：n/2 开始, 非叶子节点则从n/2 -1 开始
     *     2. 父节点表示: (i-1)/2 (i从1开始)
     *     3. 左子节点: 2i+1
     *     4. 右子节点: 2i+2
     *
     * 自底向上的构造一个最小堆，从最大的非子节点开始向后遍历
     *
     * 自顶向下，通过递归的方式来构造
     *
     * @param nums
     */
    public void createMinHeap(int[] nums){

        for(int i = (nums.length /2 -1);i>=0;i--){

            //和他们的叶子节点比较，然后交换
            int leftChild = (i<<1) + 1;
            int rightChild = (i+1) << 1;

            if(leftChild < nums.length && nums[i] > nums[leftChild]){
                int c = nums[i];
                nums[i] = nums[leftChild];
                nums[leftChild] = c;
            }

            if(rightChild < nums.length && nums[i] > nums[rightChild]){
                int c = nums[i];
                nums[i] = nums[rightChild];
                nums[rightChild] = c;
            }

        }

    }


}
