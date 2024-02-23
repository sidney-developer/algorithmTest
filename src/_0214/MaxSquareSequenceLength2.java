package _0214;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSquareSequenceLength2 {
    public static int findMaxSquareSequenceLength(int[] arr) {
        Map<Integer, Integer> lengthMap = new HashMap<>(); // 使用map缓存之前的长度信息
        Set<Integer> set = new HashSet<>();
        int maxLength = 0; // 最大平方序列长度

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (!lengthMap.containsKey(num)) {
                int length = dfs(num, set, lengthMap) > 1 ? dfs(num, set, lengthMap) : 0; // 获取以当前数字为起始的平方序列长度

                maxLength = Math.max(maxLength, length); // 更新最大平方序列长度
            }
        }

        return maxLength; // 返回结果
    }

    private static int dfs(int num,  Set<Integer> set, Map<Integer, Integer> lengthMap) {
        if (!set.contains(num * num)) { // 如果不包含当前数字的平方，则返回1（表示只有当前数字一个元素的序列）
            return 1;
        }

        int length = 1; // 初始序列长度为1（包含当前数字）
        int nextNum = num * num; // 获取下一个平方数

        if (!lengthMap.containsKey(nextNum)) {
            length += dfs(nextNum, set, lengthMap); // 递归探索下一个平方数后面的数字
        } else {
            length += lengthMap.get(nextNum); // 从map中获取已缓存的长度信息
        }

        lengthMap.put(num, length); // 缓存长度信息

        return length; // 返回序列长度
    }

    public static void main(String[] args) {
//        int[] arr = {2,3,5};
//        int maxLength = findMaxSquareSequenceLength(arr);
//        System.out.println(maxLength);
        int[] arr = {2, 8, 16, 4, 5, 6};
        int maxLength = findMaxSquareSequenceLength(arr);
        System.out.println(maxLength);

    }
}
