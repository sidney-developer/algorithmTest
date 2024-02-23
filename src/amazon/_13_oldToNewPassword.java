package amazon;

public class _13_oldToNewPassword {

    public static void main(String[] args) {
        String[] newpasswords= new String[]{"baacbab","accdb","baacba"};
        String[] oldpasswords= new String[]{"abdbc","ach","abb"};
        boolean[] ans= getOldNewPassword(oldpasswords, newpasswords);
        for (boolean an: ans) {
            System.out.println(an);
        }
    }
    public static boolean[] getOldNewPassword (String[] oldPasswords, String[] newPassWords) {

        int N= oldPasswords.length;
        boolean[] ans= new boolean[N];
        for (int i=0; i<N ;i++) {
            ans[i]= isSubSeq(oldPasswords[i], newPassWords[i]);
        }
        return  ans;
    }

    public static boolean isSubSeq (String oldPassword, String newPassword) {
        int point_old= 0;
        int point_new= 0;
        char[] oldchs= oldPassword.toCharArray();
        char[] newchs= newPassword.toCharArray();
        while (point_new!= newPassword.length() && point_old!= oldPassword.length()) {
            if (oldchs[point_old] == newchs[point_new] || oldchs[point_old]== transfer(newchs[point_new])) {
                point_new++;
                point_old++;
            }else {
                point_new++;
            }
        }
        return point_old== oldPassword.length();
    }
    public static char transfer (char ch) {
        if (ch=='z') {
            return 'a';
        }
        return  (char) (ch+1);
    }

}
