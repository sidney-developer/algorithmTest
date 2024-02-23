package amazon;

public class _35_MaxAggregateTemperatureChange {

    public static void main(String[] args) {
        int[] tempers= new int[] {6,-2,5};
        System.out.println(getMaxAggregate(tempers));
    }

    // prefix
    public static int getMaxAggregate(int[] nums) {

        int N = nums.length;
        int[] prefix= new int[N];

        prefix[0]= nums[0];
        for (int i=1; i<N; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int res= Math.max( prefix[0], prefix[N-1]);

        for (int i=1; i<N; i++) {
            res = Math.max(res, Math.max(prefix[i], prefix[N-1]- prefix[i-1]) );
        }
        return res;
    }

}
