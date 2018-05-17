package sort;

import java.util.*;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/11
 * @Description: 找出两个数组的交集元素
 */
public class Intersection {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] rstArray = intersectionRepeat(nums1, nums2);
        for(int rst : rstArray)
            System.out.println(rst);

    }

    public static int[] intersectionNoRepeat(int[] nums1, int[] nums2) {

        if(nums1.length <= 0 || nums2.length <= 0)
            return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();

        for(int i=0,j=0;i < nums1.length && j < nums2.length;){

            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }

            while(i < (nums1.length -1) && nums1[i] == nums1[i+1])
                i++;
            while(j < (nums2.length -1) && nums2[j] == nums2[j+1])
                j++;

        }

        int k = 0;
        int[] rstArray = new int[set.size()];
        for(int ele : set){
            rstArray[k++] = ele;
        }

        return rstArray;
    }

    public static int[] intersectionRepeat(int[] nums1, int[] nums2) {

        if(nums1.length <= 0 || nums2.length <= 0)
            return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        for(int i=0,j=0;i < nums1.length && j < nums2.length;){

            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }

        int[] rstArray = new int[list.size()];
        for(int i=0;i<list.size();i++)
            rstArray[i] = list.get(i);

        return rstArray;
    }

}
