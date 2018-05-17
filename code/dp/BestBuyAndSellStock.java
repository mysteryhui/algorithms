package dp;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 */

/**
 * 思路：
 *  分治法
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/9
 * @Description:
 */
public class BestBuyAndSellStock {

    public static void main(String[] args) {

       int[] prices = {7, 6, 4, 3, 1};
       int maxProfit = maxProfit(prices);
       System.out.println(maxProfit);

    }

    public static int maxProfit(int[] prices) {

        if(prices.length < 2)
            return 0;

        //n-1天的最大收益
        int maxProfit = 0;
        //n-1天中价格最低的值
        int minVal = prices[0];

        for(int i=1;i<prices.length;i++){

            int profit = prices[i] - minVal;
            maxProfit = Math.max(maxProfit,profit);

            //取当前元素和之前比较出来的最小值
            minVal = Math.min(prices[i],minVal);

        }

        return maxProfit;

    }

}
