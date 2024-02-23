package amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _25_smallestDistancePair {

    public static void main(String[] args) {
        int[] ints= new int[]{6,9,1};
        int[] ans= getSmallestKDistances(ints, 2);
        for (int a: ans) {
            System.out.println(a);
        }
    }

    public static int[] getSmallestKDistances (int[] nums, int k) {

        PriorityQueue<int[]> minHeap= new PriorityQueue<>( (a,b)-> a[0]- b[0]);

        Arrays.sort(nums);
        int N= nums.length;
        for (int i=1; i<N ; i++) {
            minHeap.add(new int[]{nums[i]- nums[i-1], i});
        }

        int[] ans= new int[k];
        for (int i=0; i<k; i++) {
            int[] temp = minHeap.poll();
            ans[i]= temp[0];
            if (temp[1] + 1 <N) {
                minHeap.add(new int[]{temp[0] + nums[temp[1]+1]- nums[temp[1]], temp[1]+1});
            }
        }
        return  ans;
    }

}
