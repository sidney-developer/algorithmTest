package amazon;

import java.util.Arrays;
import java.util.HashSet;

public class _12_UniqueAverageNum {

    public static void main(String[] args) {
        int[] nums= new int[]{1,4,1,3,5,6};
        System.out.println(getUniqueAverage(nums));

        int[] nums2= new int[]{1,1,1,1,1,1};
        System.out.println(getUniqueAverage(nums2));
    }

    public static int getUniqueAverage(int[] nums) {

        int N= nums.length;
        Arrays.sort(nums);

        HashSet<Double> set= new HashSet<>();
        int left=0;
        int right= N-1;
        while (left< right) {
            double avg= (double) (nums[left] + nums[right])/2;
            set.add(avg);
            left++;
            right--;
        }
        return  set.size();
    }

}

