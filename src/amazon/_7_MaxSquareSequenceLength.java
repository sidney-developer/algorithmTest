package amazon;

import java.util.HashMap;
import java.util.HashSet;

public class _7_MaxSquareSequenceLength {

    // dfs + map 缓存
    public static int getMaxLengthOfSequnces (int[] arr) {
        HashSet<Integer> hashSet= new HashSet<>();
        HashMap<Integer, Integer> cacheMap= new HashMap<>();
        for (int num: arr) {
            hashSet.add(num);
        }
        int maxLength=0;
        for (int num: arr) {
            if ( !cacheMap.containsKey(num)) {
                int length = dfs(num, hashSet, cacheMap);
                cacheMap.put(num, length);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static int dfs (int num, HashSet<Integer> set, HashMap<Integer, Integer> map) {
        if (map.containsKey(num)) {
            return  map.get(num);
        }
        if (!set.contains( num * num)) {
            return 1;
        }
        int length=1;
        if (map.containsKey(num * num)) {
            length+= map.get(num* num);
        }else {
            length += dfs(num* num, set, map);
        }
        map.put(num, length);
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 16, 4, 5, 6};
        int maxLength = getMaxLengthOfSequnces(arr);
        System.out.println(maxLength);
    }
}
