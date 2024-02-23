package amazon;

import java.util.HashSet;

public class _28_MaxStcokPrice {

    //  sliding windows + set,  当 set 中已经存在 即将加入的 nums[right]或者 set 内元素个数大于 k, 左指针右移动；当 set 中一直塞入不重复元素的前提下， 当 set 的长度 满足了
    // k ， 就计算一遍 maxSum
    public static void main(String[] args) {
        int[] stocks= new int[]{1,2,7,7,4,3,6};
        System.out.println(getConsecutiveMaxStockPrice(stocks, 3));
    }
    // set
    // sliding windows
    public static int getConsecutiveMaxStockPrice(int[] stocks, int k) {

        int N= stocks.length;

        int left=0;
        int maxStockSum=0;
        HashSet<Integer> set= new HashSet<>();
        for (int right=0; right<N ; right++) {
            while (set.contains(stocks[right]) || (right- left+1) > k) {
                set.remove(stocks[left++]);
            }
            set.add(stocks[right]);
            if (right- left+1==k) {
                int tempSum=0;
                for (int stock: set) {
                    tempSum+= stock;
                }
                maxStockSum = Math.max(maxStockSum, tempSum);
            }
        }
        return maxStockSum;
    }
}
