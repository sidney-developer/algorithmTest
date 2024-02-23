package amazon;

import java.util.Arrays;

public class _39_PmatchingScore {

    public static void main(String[] args) {
        String s1= "acbbca";
        String s2= "acb";
        int p=2;
        System.out.println(pMatching(s1, s2, p));
    }


    public static int pMatching (String s1, String s2, int p) {

        char[] chs2= s2.toCharArray();
        char[] chs1= s1.toCharArray();
        int[] debts2= new int[26];
        for (char ch: chs2) {
            debts2[ch-'a']++;
        }
        int result=0;
        int finalStart= chs1.length- (chs2.length-1) * p;
        for (int i=0; i< finalStart; i++) {
            boolean isValid= true;
            int[] debts= Arrays.copyOf(debts2, debts2.length);
            for (int j=0 ; j< chs2.length; j++) {
                debts [chs1 [i+ j * p] - 'a'] --;
                if ( debts [chs1 [i+ j * p] - 'a'] <0) {
                    isValid= false;
                    break;
                }
            }
            if (isValid) {
                result++;
            }
        }
        return result;
    }
}
