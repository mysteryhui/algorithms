package bit;

import sun.jvm.hotspot.utilities.BitMap;

import java.util.BitSet;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/29
 * @Description: BitSet使用
 *
 * 1. 可以使用BitSet进行排序
 * 2. 通过BitSet查看某个元素是否存在
 *
 */
public class BitSort {

    public static void main(String[] args) {

        BitSet bitSet = new BitSet(10);
        for(int i=0; i<10; i++){
            if(i%2 == 0)
                bitSet.set(i);
        }

        System.out.println(bitSet.length());

        for(int i=0; i<bitSet.length(); i++){
            if(bitSet.get(i))
                System.out.println(i);
        }


    }

}
