package amazon;

public class _9_CommonPrefix {

    public static void main(String[] args) {
        String s= "abcabcd";
        System.out.println(getLengthOfCommenPrefix(s));
    }

    public static int getLengthOfCommenPrefix (String s) {

        int N= s.length();
        char[] chs= s.toCharArray();
        int res= s.length();

        for (int i=0; i< N-1; i++) {
            int count=0;
            for (int j=i+1; j<N ; j++) {
                if (chs[j - i - 1] == chs[j]) {
                    count++;
                } else {
                    break;
                }
            }
            res += count;
        }
        return res;
    }

}
