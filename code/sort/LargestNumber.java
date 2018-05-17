package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/16
 * @Description:
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        String largestNum = "";

        //使用桶排序，对所有的元素按照高位进行排序
        Integer[] s = null;
        Arrays.sort(s, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 == o2)
                    return 0;

                //计算高位

                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        return largestNum;
    }

}
