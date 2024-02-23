import java.util.Arrays;

public class question5 {

    public static void main(String[] args) {
        int[][] arr1= new int[][]{{1,1},{1,1},{1,1},{1,1}};
        int k=2;
        int[][] ints = kClosest(arr1, 2);
        System.out.println( ints);
    }

    public static int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    //  返回的 l 以及左边的位置一定是 <= pivot的，但不一定所有 <=pivot的数都在它左边，有可能 返回的 l 是连续相同的数中的某个位置，左边都是小于等于，右边都是大于等于，但不影响继续二分下去
    // 如果 l <k 则说明 左边 l 个位置都满足了，那我缩小范围 令 left= l+1 ； 反之相反；  最后 当返回的 l 正好是 k时候，则说明前 k 个元素都满足 <= arr[k],就是原数组中 前 k 小的数字;
    private static int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private static int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
