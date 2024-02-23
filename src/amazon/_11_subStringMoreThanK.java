package amazon;

import java.util.HashMap;
import java.util.Map;

public class _11_subStringMoreThanK {

    public static void main(String[] args) {
        String s= "abbcac";
        System.out.println(getSubStringMoreThanK(s,1));

        String s2= "abdccdbada";
        System.out.println(getSubStringMoreThanK(s2,2));
    }

    // 用 hashMap<Character, int[]> 的结构，ints[0] 装该字符左边出现的次数，ints[1] 装该字符右边出现的次数；
    public static int getSubStringMoreThanK (String str, int k) {

        char[] chs= str.toCharArray();
        HashMap<Character, int[]> countsOfLeftRight= new HashMap<>();

        for (char ch: chs) {
            if (!countsOfLeftRight.containsKey(ch)) {
                countsOfLeftRight.put(ch,new int[]{0,1});
            }else {
                int[] temp= countsOfLeftRight.get(ch);
                temp[1]++;
                countsOfLeftRight.put(ch,temp);
            }
        }
        int res=0;
        for (char ch: chs) {
            if (!countsOfLeftRight.containsKey(ch)) {
                continue;
            }
            int[] temp= countsOfLeftRight.get(ch);
            temp[0]++;
            temp[1]--;
            if (temp[1]==0) {
                countsOfLeftRight.remove(ch);
            }
            res+= valid (countsOfLeftRight,k) ? 1:0;
        }
        return res;
    }
    public static boolean valid (HashMap<Character, int[]> map, int k) {
        int count=0;
        for (int[] value: map.values()) {
            if (value[0]!=0 && value[1]!=0) {
                count++;
            }
        }
        return count>k;
    }
}
