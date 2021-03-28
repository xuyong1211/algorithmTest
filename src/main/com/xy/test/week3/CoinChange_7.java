package main.com.xy.test.week3;

public class CoinChange_7 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE-1;//取MAX_VALUE不行？为啥啊
        }

        dp[0] = 0;
        //

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(coin <= i){//硬币大于要配的数额忽略
                    dp[i] = Math.min(dp[i],dp[i-coin] + 1);//要配的数额为最后一步是其他币种的方式总数 和  最后一步为当前币 往前推币种面值步处的方式总数加一
                }
            }
        }

        return  (dp[amount]>amount)?-1 : dp[amount];
    }
}
