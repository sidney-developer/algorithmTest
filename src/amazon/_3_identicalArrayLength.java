package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _3_identicalArrayLength {

    // 用 HashMap<Integer, List<Integer>> 遍历一遍  把每个数字的索引记下来，然后过一遍每个数字的索引(sliding window)，找符合 deleted<= k的最大长度；

    public static int findIdenticalLength (int[] arr, int k) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for (int i=0; i< arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        int maxLength=1;
        for (List<Integer> list :map.values() ) {
            if (list.size()==1) {
                continue;
            }
            int left=0;
            int deleted=0;
            for (int right=1; right< list.size() ; right++) {
                deleted += (list.get(right)-list.get(right-1)-1);
                while (deleted>k ) {
                    deleted -= (list.get(left + 1) - list.get(left) - 1);
                    left++;
                }
                maxLength= Math.max(maxLength, right- left +1);
            }
        }
        return  maxLength;
    }
    /**
     * 把问题转换为看在容忍k个不同元素的情况下，有多少个连续的元素，求连续元素的最大值
     *
     * 思路为对每个元素都进行检查，如果后面的元素与当前元素相等，则累计当前连续长度，
     * 如果不相等，分两种情况
     * 情况1：如果当前之间不同元素的个数还小于k，继续遍历检查
     * 情况2：如果当前之间不同元素的个数不小于k，直接跳过本元素检查
     *
     * 每轮循环后求最值
     */
    public static int findMaxLength(int[] arr, int k) {
        int maxLength = 0;   // 最大连续长度
        int currentLength = 1;    // 当前连续长度
        int count = 0;    // 记录与当前循环最左边元素不同的元素数量

        for (int left = 0; left < arr.length - 1; left++) {
            for (int right = left + 1; right < arr.length; right++) {
                // 如果左右两个元素相等，当前连续长度加1
                if (arr[left] == arr[right]) {
                    currentLength++;
                } else {
                    // 如果中间不同的元素小于k，新增count
                    if (count < k) {
                        count++;
                    }
                    // 否则直接跳出循环，看下一个元素
                    else {
                        break;
                    }
                }
            }
            // 更新最大连续长度
            maxLength = Math.max(currentLength, maxLength);
            // 重置当前连续长度为1
            currentLength = 1;
            // 重置不同元素的数量为0
            count = 0;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,2,2,5};
        int k = 2;
        int result = findMaxLength(arr, k);
        System.out.println(result);
        int result2 = findIdenticalLength(arr, k);
        System.out.println(result2);
    }
}
