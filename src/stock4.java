public class stock4 {

    public int maxProfit(int k, int[] prices) {

        int N= prices.length;
        if ( k >=N/2) {
            return getMoney(prices);
        }

        int[][] dp= new int[N][k+1];

        for (int kIndex=1; kIndex<=k; kIndex++) {
            int best= dp[0][kIndex-1] - prices[1];
            dp[1][kIndex]= Math.max(dp[0][kIndex], best+ prices[1]);
            for (int priceIndex=2; priceIndex< N; priceIndex++) {
                int p1= dp[priceIndex-1][kIndex];
                best= Math.max(best, dp[priceIndex-1][kIndex-1]- prices[priceIndex]);
                int p2= best + prices[priceIndex];
                dp[priceIndex][kIndex]= Math.max(p1,p2);
            }
        }
        return dp[N-1][k];
    }

    public int getMoney (int[] prices) {
        int total=0;
        for (int i=1; i< prices.length; i++) {
            total += Math.max(0, prices[i]- prices[i-1]);
        }
        return total;
    }

}
