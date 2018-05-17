package array;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 1000
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/7
 * @Description:
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 101;
        boolean rst = palindromeNumber.isPalindrome(x);
        System.out.println(rst);

    }

    public boolean isPalindrome(int x) {

        if(x<0)
            return false;
        else if(x == 0){
            return true;
        }else {

            //x与x'相等
            int temp = x;
            int y = 0;

            while(temp > 0){

                y = y*10 + temp%10;
                temp = temp/10;
            }

            if(y == x)
                return true;

            return false;
        }

    }

}
