package amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestSubarray {

    public static void main(String[] args) {
        int[] arr = {3, 5, -2};
        int k = 3;

        int[] bestSubsetSums = getKSmallest(arr, k);
        System.out.println(Arrays.toString(bestSubsetSums));
    }

    public static int[] getKSmallest (int[] nums, int k) {

        // 先获得所有 正数的和，并且将原数组中的负数变为正数；
        int N= nums.length;
        int maxSum=0;
        for (int i=0; i < N; i++) {
            if (nums[i] >=0 ) {
                maxSum += nums[i];
            }else  {
                nums[i] = -nums[i];
            }
        }
        // 排序
        Arrays.sort(nums);
        // 在全是正数的情况下，获得最小的 k 个 subArray 的 sum
        // PriorityQueue with arrays where arr[0] is sum, arr[1] is end index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        int[] result = new int[k-1];

        // Initially add the first element of each subarray to the minHeap
//        for (int i = 0; i < nums.length; i++) {
//            minHeap.add(new int[]{nums[i], i});
//        }
        minHeap.add(new int[]{nums[0], 0});
        for (int i = 0; i < k-1; i++) {
            int[] current = minHeap.poll();
            result[i] = current[0]; // Store the sum

            // If the subarray can be extended, add the new subarray sum to the minHeap
            if (current[1] < nums.length - 1) {
                minHeap.add(new int[]{current[0] + nums[current[1] + 1], current[1] + 1});
                minHeap.add(new int[]{current[0] - nums[current[1]]+ nums[current[1] + 1], current[1] + 1});
            }

        }

       // 答案就是 第一个数是 maxSum,后面的数 就是 maxSum 依次减去 result中从小到大的 subArray Sum 的结果
        int[] ans= new int[k];
        ans[0]= maxSum;
        for (int i=1; i<k; i++) {
            ans[i]= maxSum- result[i-1];
        }
        return ans;
    }
}
