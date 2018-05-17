package array;


/**
 * 题目是求矩形的最大值，然后题目可以转换成，求数组nums中，连续k个元素，k*k个元素的最小值，即k*min{nums[i],..nums[i+k]}
 *
 * k = n时，
 *    n*min{heights[i]....heights[i+n]}
 *
 * k = n +1时，
 *      (n+1) * min{heights[i]....heights[i+n+1]  }
 *      if(heights[i+n] > heights[i+n+1])
 *          heights
 *
 */

import sun.font.GlyphLayout;

import java.util.Stack;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/4
 * @Description:
 */
public class LargestRectangleArea {

    public static void main(String[] args) {

//        int length = 1000;
//        int[] heights = new int[length];
//        for(int i=0;i<heights.length;i++)
//            heights[i] = i+1;

        int[] heights = {3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3};
        LargestRectangleArea object = new LargestRectangleArea();
        long startTime = System.currentTimeMillis();
//        int maxArea1 = object.largestRectangleAreaViolence3(heights);
        int maxArea1 = object.largestRectangleArea(heights);

//        int mid = (heights.length-1)/2;
//        int maxArea = object.maxArea(heights,0,9);
//        int maxArea = object.maxCombineArea(heights,0,mid,heights.length-1);
//        int left = mid+1,right = heights.length -1,mid2 = left + (right - left)/2;
//        int rightArea = object.maxCombineArea(heights,0,19/2,19);
//        System.out.println("rightArea : " + rightArea);

        int maxArea = object.largestRectangleAreaDQ(heights);
        long endTime = System.currentTimeMillis();
        System.out.println(maxArea);
        System.out.println(maxArea1);
        System.out.println(endTime - startTime);



    }

    /**
     * O(n)的复杂度解决问题
     *
     * 使用栈保存当前 最小元素 -- 第二小元素 -- 第三小元素。。。 依次保存，当遇到不符合条件的元素，就出栈，弹出然后计算结果
     *
     * 计算面积的思路可以转换成如下，即以数组中某个元素k为最小元素，找到左右两边第一个比它小的元素的索引left index(ln),right index(rn),这样计算以k为最小元素的面积为k*(j-i-1),
     * 如果正常的遍历的话，就需要O(n^2)的复杂度；
     *
     * 辅助stack来保存数据，就可以在一次遍历的情况下解决问题;
     *
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {


        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<= heights.length;i++){

            //考虑i到右边界之后，栈中还有元素的情况
            int currentVal = i == heights.length ? 0 : heights[i];

            if(stack.isEmpty() || currentVal > heights[stack.peek()])
                stack.push(i);
            else {

                //遇到一个比栈顶元素小的元素，就说明找到了栈顶元素的rn
                int minVal = heights[stack.pop()];
                int rightIndex = i;
                //如果取出栈顶元素之后，stack为空，那么说明这个元素为，currentVal的左边最小的元素，所以这时宽度就是到当前元素

                if(stack.isEmpty()){
                    //计算以栈顶元素为最小值的面积
                    maxArea = Math.max(maxArea,minVal * rightIndex);
                }else {
                    int leftIndex = stack.peek();
                    //计算以栈顶元素为最小值的面积
                    maxArea = Math.max(maxArea,minVal * (rightIndex - leftIndex -1));
                }

                //回退i，然后再和栈顶元素比较
                i--;
            }

        }

        return maxArea;

    }

    /**
     * 通过暴力方法来解决问题
     * @param heights
     * @return
     */
    public int largestRectangleAreaViolence(int[] heights) {

        int maxArea = 0;
        //k个连续元素
        for(int k=1;k<= heights.length;k++){

            // 由于内部循环，每次只是指针向后移动一位，而指针向后移动的过程中，
            // 如果新的值小于原来集合中的最小元素，则重新计算；
            // 如果后面一个元素大于原集合，则重新计算；
            for(int i = 0;i+k <= heights.length;i++){

                int minHeight = findMin(heights,i,i+k);
                int area = minHeight * k;
                if(area > maxArea)
                    maxArea = area;

            }


        }

        return maxArea;
    }

    public int largestRectangleAreaViolence2(int[] heights) {

        int maxArea = 0;
        //k个连续元素
        //找出外部循环之间的联系
        for(int i=0;i < heights.length;i++){

            // 由于内部循环，每次只是指针向后移动一位，而指针向后移动的过程中，
            // 如果新的值小于原来集合中的最小元素，则重新计算；
            // 如果后面一个元素大于原集合，则重新计算；
            int minHeight = heights[i];
            for(int k = 1;i+k <= heights.length;k++){

//                int minHeight = findMin(heights,i,i+k);
                //对于k++之后，只是增加了一个heights[i+k-1]而已
                if(heights[i+k-1] < minHeight)
                    minHeight = heights[i+k-1];

                int area = minHeight * k;
                if(area > maxArea)
                    maxArea = area;

            }


        }

        return maxArea;
    }
    /**
     * 从startIndex和endIndex中找出其中的最小值
     * @param num
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int findMin(int[] num, int startIndex,int endIndex){

        int min = num[startIndex];
        for(int i = startIndex +1;i < endIndex;i++){

            if(num[i] < min)
                min = num[i];
        }

        return min;

    }

    /**
     * 暴力破解方法，第一能简单想到的方法，就是计算以每个数组的元素为最小值的面积，然后比较大小，找出最大值
     * 复杂度为n^2
     * @param heights
     * @return
     */
    public int largestRectangleAreaViolence3(int[] heights) {

        int maxArea = 0;
        int[] num = new int[3];
        for(int i=0;i<heights.length;i++){

            //找出以当前元素为最小值的元素面积
            //以左右两边寻找比当前元素小的元素下标ln,rn，然后计算出面积
            int left = i-1,right = i+1;
            while(left > 0 && heights[left] >= heights[i])
                left--;

            while(right < heights.length && heights[right] >= heights[i])
                right++;

            int area = (right - left - 1)*heights[i];
            if(area > maxArea){
                maxArea = area;
                num[0] = heights[i];
                num[1] = left;
                num[2] = right;
            }


        }
        System.out.println("height : " + num[0] + ", left : " + num[1] + ", right : " + num[2]);

        return maxArea;
    }

    /**
     * 使用分治法来解决
     *
     * 计算直方图中的最大面积可以转换成如下：
     *      取直方图的数组的中点元素m，直方图的最大面积只会有三种情况：
 *      1. 最大面积在元素m的左边；
 *      2. 最大面积在元素m的右边；
 *      3. 最大面积经过元素m；
     *
     *
     * @param
     * @return
     */
    public int largestRectangleAreaDQ(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        return maxArea(height,0,height.length-1);
    }

    int maxArea(int[] height, int l, int r) {

        //一直分解直到求解的直方图大小为1的情况
        if(l == r)
            return height[l];

        int m = l + (r-l)/2;

        //计算左边的最大面积
        int leftArea = maxArea(height,l,m);
        //计算右边的最大面积
        int rightArea = maxArea(height,m+1,r);
        //计算经过中点的最大面积，即经过m和m+1，这两个元素的面积
        int midArea = maxCombineArea(height,l,m,r);

        int maxArea = Math.max(midArea,Math.max(leftArea,rightArea));
        return maxArea;
    }


    /**
     * 计算 经过 m和m+1两个元素的最大面积
     * @param height
     * @param l
     * @param m
     * @param r
     * @return
     */
    int maxCombineArea(int[] height, int l, int m, int r) {

        int j = m,k=m+1;
        int minVal = Math.min(height[j],height[k]);
        int maxArea = 0;
        while(j>= l && k <= r){

            minVal = Math.min(minVal,Math.min(height[j],height[k]));
            maxArea = Math.max(maxArea,(k-j+1)*minVal);
            if(j == l)
                k++;
            else if(k == r)
                j--;
            else {

                if(height[j-1] > height[k+1])
                    j--;
                else
                    k++;

            }

        }

        return maxArea;

    }


}
