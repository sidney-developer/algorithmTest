package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static int[] getBestK(int[] arr, int k) {
        List<Integer> subsetSums = new ArrayList<>();

        backtrack(arr, 0, 0, subsetSums);

        Collections.sort(subsetSums, Collections.reverseOrder());

        int[] result = new int[k];
        for (int i = 0; i < k && i < subsetSums.size(); i++) {
            result[i] = subsetSums.get(i);
        }

        return result;
    }

    /**
     * 递归地生成所有可能的子集和。通过回溯的方式遍历数组中的元素，并构建包含和不包含当前元素的子集和。
     * 通过这两个递归调用，实现对数组的每个元素进行两种选择：包含或不包含。这样可以生成所有可能的子集和。
     *
     * 该算法使用深度优先搜索策略，以树形结构遍历所有可能的解空间。每个节点代表一个选择，从根节点开始，分支出两个子节点，分别对应包含和不包含当前元素的情况。
     * 最终，会遍历到叶子节点，即找到了一个完整的子集和。通过这种方式，能够生成所有可能的子集和，并将其存储在 subsetSums 列表中。
     */
    private static void backtrack(int[] arr, int index, int sum, List<Integer> subsetSums) {
        // 检查是否已经遍历完整个数组。如果是，则将当前子集和 sum 添加到 subsetSums 列表中，并返回。
        if (index == arr.length) {
            subsetSums.add(sum);
            return;
        }

        // 如果尚未遍历完整个数组，则进行两个递归调用：

        // 将当前元素包含在子集中。递增索引 index，并将当前元素的值添加到当前子集和 sum 中，然后递归调用 backtrack 方法。
        backtrack(arr, index + 1, sum + arr[index], subsetSums);

        // 不将当前元素包含在子集中。只递增索引 index，保持当前子集和 sum 不变，然后递归调用 backtrack 方法。
        backtrack(arr, index + 1, sum, subsetSums);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -2};
        int k = 3;

        int[] bestSubsetSums = getBestK(arr, k);
        System.out.println(Arrays.toString(bestSubsetSums));
    }
}
