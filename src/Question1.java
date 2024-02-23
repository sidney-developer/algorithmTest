import java.util.Arrays;
import java.util.List;

public class Question1 {

    public static long getMaximumProfit(List<Integer> price, List<Integer> profit) {
        int n = price.size();

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill with initial values
        for (int i = 0; i < n; i++) {
            leftMax[i] = -1;
            rightMax[i] = -1;
        }

        // Calculate left maximum for values in profit with conditions on price
        int maxLeftValue = -1;
        int minArray1SoFar = price.get(0);
        for (int i = 1; i < n; i++) {
            if (price.get(i) > minArray1SoFar) {
                maxLeftValue = Math.max(maxLeftValue, profit.get(i - 1));
            }
            leftMax[i] = maxLeftValue;
            minArray1SoFar = Math.min(minArray1SoFar, price.get(i));
        }

        // Calculate right maximum for values in profit with conditions on price
        int maxRightValue = -1;
        int maxArray1SoFar = price.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (price.get(i) < maxArray1SoFar) {
                maxRightValue = Math.max(maxRightValue, profit.get(i + 1));
            }
            rightMax[i] = maxRightValue;
            maxArray1SoFar = Math.max(maxArray1SoFar, price.get(i));
        }

        // Calculate maximum sum using leftMax, profit, and rightMax
        long maxSum = -1;
        for (int i = 1; i < n - 1; i++) {
            if (leftMax[i] != -1 && rightMax[i] != -1) {
                maxSum = Math.max(maxSum, (long) leftMax[i] + profit.get(i) + rightMax[i]);
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        List<Integer> price1 = Arrays.asList(2,3,6,5,9);
        List<Integer> profit1 = Arrays.asList(1,2,6,1,5);
        System.out.println(getMaximumProfit(price1, profit1)); // Expected: 12

        List<Integer> price2 = Arrays.asList(4,3,2,1);
        List<Integer> profit2 = Arrays.asList(4,3,2,1);
        System.out.println(getMaximumProfit(price2, profit2)); // Expected: -1

        List<Integer> price3 = Arrays.asList(1, 5, 3, 4, 6);
        List<Integer> profit3 = Arrays.asList(2, 3, 4, 5, 6);
        System.out.println(getMaximumProfit(price3, profit3)); // Expected: 15
    }
}