package amazon;

public class _14_lexicographicallySmallestPalindrome {

    // two pointers
    public static String getLexicollyPalidrome (String s) {
        int N= s.length();
        char[] chs= s.toCharArray();
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<N ; i++) {
            sb.append((char) Math.min(chs[i], chs[N-1-i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String password = "cbatabc";
        int[] v = new int[26]; // Initialize counts for 'a' to 'z'

        // Count each character in the password
        for (char c : password.toCharArray()) {
            v[c - 'a']++;
        }

        // Build the first half of the palindrome
        String res = "";
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            String tmp = new String(new char[v[i] / 2]).replace('\0', (char)('a' + i));
            res += tmp;
            if (v[i] % 2 == 1) {
                mid = (char)('a' + i);
            }
        }

        // Add the middle character for odd length passwords
        if (password.length() % 2 == 1) {
            res += mid;
        }

        // Build the next half of the palindrome
        int l = res.length();
        for (int i = l - 1 - (password.length() % 2); i >= 0; i--) {
            res += res.charAt(i);
        }

        System.out.println(res);
        System.out.println(getLexicollyPalidrome(res));
    }


}
