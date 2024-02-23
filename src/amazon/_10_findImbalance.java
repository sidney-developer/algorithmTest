package amazon;

import java.util.HashSet;

public class _10_findImbalance {

    public static int getImBalance (int[] arr) {

        int N= arr.length;
        int result=0;
        for (int i=0 ; i<N; i++) {
            HashSet<Integer> set= new HashSet<>();
            int cur=0;
            for (int j=i; j<N; j++) {
                int temp = arr[j];
                if (set.contains(temp)) {
                    continue;
                } else if (set.contains(temp - 1) && set.contains(temp + 1)) {
                    cur--;
                } else if (!set.contains(temp - 1) && !set.contains(temp + 1) && !set.isEmpty()) {
                    cur++;
                }
                set.add(temp);
                result += cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2};
        int imbalanceTotal1 = getImBalance(array);
        System.out.println(imbalanceTotal1);

    }
}
