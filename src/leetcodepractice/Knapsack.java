package leetcodepractice;

import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsack(new int[]{6, 10, 12}, new int[]{1, 2, 3},5));
    }

    private int knapsack(int[] vals, int[] weight, int maxWeight) {
        int[][] dp = new int[weight.length + 1][maxWeight + 1];

        for(int i = 1; i <= weight.length; i++){
            for(int w = 1; w <= maxWeight; w++){
                if(w < weight[i-1]){
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(dp[i-1][w], vals[i-1] + dp[i-1][w - weight[i-1]]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[weight.length][maxWeight];
    }


}
