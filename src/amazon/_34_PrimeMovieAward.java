package amazon;

import java.util.Arrays;

public class _34_PrimeMovieAward {

    public static void main(String[] args) {
        int[] nums= new int[]{1,5,4,6,8,9,2};
        System.out.println(getGroupNumbers(nums,3));
    }

    public static int getGroupNumbers (int[] awards, int k) {

        Arrays.sort(awards);
        int count=1;
        int range=awards[0] + k;
        for (int i=0; i<awards.length; i++) {
            if (awards[i] > range) {
                count++;
                range = awards[i] + k;
            }
        }
        return count;
    }
}
