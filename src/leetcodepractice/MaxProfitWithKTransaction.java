package leetcodepractice;

import java.util.Arrays;

public class MaxProfitWithKTransaction {

    public static void main(String[] args) {
        MaxProfitWithKTransaction maxProfit = new MaxProfitWithKTransaction();
        System.out.println(maxProfit.maxProfit(new int[]{5,11,3,50,60,90},2));
    }

    private int maxProfit(int[] prices, int k) {
        int[][] dp = new int[k + 1][prices.length];

        for(int t = 1; t <= k; t++){
            int minSoFar = prices[0];
            int minSoFarIndex = 0;
            for(int p = 0; p < prices.length; p++){
                if(p < t){
                    dp[t][p] = dp[t-1][p];
                }else{
                    dp[t][p] = Math.max(dp[t][p-1], prices[p] - minSoFar + dp[t-1][minSoFarIndex]);
                }

                if(prices[p] <= minSoFar){
                    minSoFar = prices[p];
                    minSoFarIndex = p;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[k][prices.length-1];
    }


}
