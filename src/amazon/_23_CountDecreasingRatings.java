package amazon;

public class _23_CountDecreasingRatings {


    public static void main(String[] args) {

        int[] arr= {4, 3, 2, 5, 9, 8};
        System.out.println(getDecreasingCounts(arr));
        int[] arr2= {4,3,5,4,3};
        System.out.println(getDecreasingCounts(arr2));
    }


    public static int getDecreasingCounts (int[] nums) {

        int N= nums.length;
        int count=1;
        int res=0;
        for (int i=1; i< N; i++) {
            if (nums[i] == nums[i-1]-1) {
                count++;
            }else {
                res += (count+1)* count /2;
                count=1;
            }
        }
        res += count * (count+1) /2;
        return res;
    }
}
