package _0214;

import java.util.HashSet;
import java.util.Set;

public class ImbalanceCalculator {

    /**
     * 使用O(n^2)遍历每个连续子数组并排序，再遍历排序后的子数组求的不平衡数字，则时间复杂度最坏是O(n^3)。
     * 在这个基础上，可以进行简化。外层O(n^2)的遍历难以避免，那么我们看看排序这一步可不可以省略，即利用之前的计算结果来增量计算下一步。
     *
     * 给定一个排序数组sorted(nums[i:j])，我们添加nums[j + 1]时，不外乎几种情况
     *
     * nums[j + 1]已经出现在前面的数组里面了，因此不会对不平衡数字产生影响。
     * nums[j + 1] + 1 或 nums[j + 1] - 1已经出现在前面的数组里面了，因此添加nums[j + 1]会使得不平衡数字减少1。
     * 若nums[i:j]为空，添加一个数字不平衡数字还是0。
     * 非以上两种情况，且已经有数字时，添加nums[j + 1]会使得不平衡数字增加1。
     */
    public static int calculateImbalance1(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            int curr = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];
                if (s.contains(x)) {
                    continue;
                } else if (s.contains(x - 1) && s.contains(x + 1)) {
                    curr -= 1;
                } else if (!s.contains(x - 1) && !s.contains(x + 1) && !s.isEmpty()) {
                    curr += 1;
                }
                s.add(x);
                result += curr;
            }
        }

        return result;
    }

    /**
     * 可以采用类似动态规划的思想进行逐步推进，每次都在上一次的基础上修改；
     * 只需要关注前一个 num 、 num+1 和 num−1 最后一个位置即可计算准确的影响范围进而计算当前的不平衡数字；
     */
    public static int calculateImbalance2(int[] nums) {
        int[] map = new int[nums.length + 2]; // 创建一个大小为n+2的数组map，用于记录每个数字的最后出现位置
        int ans = 0; // 用于记录子数组imbalance的总个数
        int sum = 0; // 用于记录当前子数组的imbalance值；
        int num; // 表示当前遍历到的数字
        int lastIndex; // 表示 num 在 map 数组中对应的最后出现位置
        map[nums[0]] = 1; // 将第一个数字的最后出现位置设为1

        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            lastIndex = map[num]; // 获取当前数字的最后出现位置
            if (map[num - 1] > lastIndex) { // 如果当前数字的前一个数字的最后出现位置大于当前数字的最后出现位置
                sum -= map[num - 1] - lastIndex; // 减去前一个数字的最后出现位置与当前数字的最后出现位置之差
            }
            if (map[num + 1] > lastIndex) { // 如果当前数字的后一个数字的最后出现位置大于当前数字的最后出现位置
                sum -= map[num + 1] - lastIndex; // 减去后一个数字的最后出现位置与当前数字的最后出现位置之差
            }
            sum += i - lastIndex; // 将当前位置与当前数字的最后出现位置之差加入总和sum中
            map[num] = i + 1; // 更新当前数字的最后出现位置为当前位置+1
            ans += sum; // 将sum累加到ans中
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2};
        int imbalanceTotal1 = calculateImbalance1(array);
        System.out.println(imbalanceTotal1);

        int imbalanceTotal2 = calculateImbalance2(array);
        System.out.println(imbalanceTotal2);
    }
}
