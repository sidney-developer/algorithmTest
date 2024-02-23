package amazon;

import java.util.HashMap;

public class _20_HowManyTinS {

    public static void main(String[] args) {
        String s= "mononom";
        String t= "mon";
        System.out.println(findTinS(s,t));
    }

    public static int findTinS (String s, String t) {
        char[] chs_s= s.toCharArray();
        char[] chs_t= t.toCharArray();

        HashMap<Character, Integer> map= new HashMap<>();
        for (char ch: chs_s) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        HashMap<Character, Integer> map2= new HashMap<>();
        for (char ch: chs_t) {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        int count=Integer.MAX_VALUE;
        for (char ch: chs_t) {
            if (!map.containsKey(ch)) {
                return 0;
            }
            count= Math.min(count, map.get(ch) / map2.get(ch));
        }
            return count;
    }

}
