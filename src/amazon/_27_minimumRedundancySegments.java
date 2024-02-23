package amazon;

import java.util.HashSet;

public class _27_minimumRedundancySegments {

    public static void main(String[] args) {
        String str="alabama";
        System.out.println(getRedundantNumber(str));
    }

    public static int getRedundantNumber (String password) {

        char[] chs= password.toCharArray();

        HashSet<Character> set= new HashSet<>();
        int count=1;

        for (char ch: chs) {
            if (set.contains(ch)) {
                set.clear();
                count++;
            }
            set.add(ch);
        }
        return count;
    }
}
