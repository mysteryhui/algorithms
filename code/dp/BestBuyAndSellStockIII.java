package dp;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/12
 * @Description:
 */
public class BestBuyAndSellStockIII {

    public static void main(String[] args) {

        int[] prices = {10, 22, 5, 75, 65, 80};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

    }

    /**
     * 有两次收益，最终收益的状态方程可以变成如下
     *
     *  profit(n) = maxProfit(0-i) + maxProfit(i-n);
     *
     *  maxProfit表示一次交易的最大收益
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if(prices.length < 2){
            return 0;
        }

        int sum = 0;
        int minVal = prices[0];
        int[] profits = new int[prices.length];
        profits[0] = 0;

        //先计算只有一次交易的情况下，每个元素的最大收益
        //即计算maxProfit(0-i) ( 1 <= i <= n )
        for(int i=1;i < prices.length;i++){

            minVal = Math.min(minVal,prices[i-1]);
            sum = Math.max(sum,prices[i] - minVal);

            //第i个元素的一次交易的最大收益为profits[i]
            profits[i] = sum;
        }

        //计算maxProfit(i-n)的收益，然后与profits相加
        //由于是计算i - n之间的最大收益，也就是可以逆向遍历，求解结果
        int maxVal = prices[prices.length -1];
        sum = profits[prices.length -1];
        for(int i= prices.length -2;i >= 0;i--){

            maxVal = Math.max(prices[i+1],maxVal);
            sum = Math.max(sum,maxVal-prices[i] + profits[i]);
        }

        return sum;
    }
}
