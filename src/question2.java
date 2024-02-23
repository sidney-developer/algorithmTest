import java.util.*;

public class question2 {

    public static void main(String[] args) {
        int[] chargeTimes= new int[]{3,6,1,3,4};
        int[] runningCosts= new int[]{2,1,3,4,5};
        int budget =25;
        int ans= maximumRobots(chargeTimes,runningCosts, budget);
        System.out.println(ans);
    }


    //3
    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long sum = 0;
        int i = 0, n = chargeTimes.length;
        Deque<Integer> d = new LinkedList<Integer>();
        for (int j = 0; j < n; ++j) {
            sum += runningCosts[j];
            while (!d.isEmpty() && chargeTimes[d.peekLast()] <= chargeTimes[j])
                d.pollLast();
            d.addLast(j);
            if (chargeTimes[d.getFirst()] + (j - i + 1) * sum > budget) {
                if (d.getFirst() == i)
                    d.pollFirst();
                sum -= runningCosts[i++];
            }
        }
        return n - i;
    }


}
