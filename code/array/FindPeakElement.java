package array;

import java.util.Stack;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/8
 * @Description:
 */
public class FindPeakElement {


    public int findPeakElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<= nums.length;i++){

            int currentVal;
            if(i == -1 || i == nums.length)
                currentVal = Integer.MIN_VALUE;
            else
                currentVal = nums[i];

            if(stack.isEmpty() || currentVal > nums[stack.peek()])
                stack.push(i);
            else {

                int index = stack.pop();
                if(stack.isEmpty()){
                    continue;
                }else
                    return index;

            }

        }

        return -1;

    }
}
