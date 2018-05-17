package array;

/**
 * @Author : wanghui
 * @Date : create on 2018/2/12
 * @Description:
 *
 *  给定一个数组和一个值，在原数组上移除所有和给定值相等的的元素，同时返回原数组
 *
 * 例如：
 *  给定数组 1，2，2，3，2，4
 *  给定元素2需要移除
 *  返回: 1,3,4
 *
 *
 *
 */
public class RemoveElements {


    public static void main(String[] args){

        int[] array = {1,2,2,3,4,2,5};
        int value = 2;
        int[] newArray = removeElements(array,2);

        for(int i=0;i<newArray.length;i++){
            System.out.println(newArray[i]);
        }

    }

    public static int[] removeElements(int[] array, int value){

        int i=0,j=0;
        for(;i<array.length;i++){

            if(array[i] == value){
                continue;
            }

            //遍历数组，直到找到符合条件的元素，然后赋值回原数组
            array[j++] = array[i];

        }

        //移除多余元素
        for(;j<array.length;j++){
            array[j] = 0;
        }

        return array;

    }

}
