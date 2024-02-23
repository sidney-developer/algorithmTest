import java.util.*;

public class Twitter {

    public static void main(String[] args) {
//        Twitter tw= new Twitter();
//        tw.postTweet(1,5);
//        List<Integer> newsFeed = tw.getNewsFeed(1);
//        tw.follow(1,2);
//        tw.postTweet(2,6);
//        List<Integer> newsFeed1 = tw.getNewsFeed(1);
//        tw.unfollow(1,2);
//        List<Integer> newsFeed2 = tw.getNewsFeed(1);
//        HashMap<Integer, Integer> map= new HashMap<>();

    }

    //3
    public boolean isIsomorphic(String s, String t) {

        int[] mappingStoT = new int[256];
        int[] mappingTtoS = new int[256];

        Arrays.fill(mappingStoT,-1);
        Arrays.fill(mappingTtoS,-1);

        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        int N= s.length();
        HashMap<Integer, Integer> map= new HashMap<>();


        for (int i=0; i< N; i++) {
            char charS= chars_s[i];
            char charT= chars_t[i];
            if (mappingStoT[charS]==-1 && mappingTtoS[charT]==-1) {
                mappingStoT[charS]= charT;
                mappingTtoS[charT]= charS;
            }

            if ( !(mappingStoT[charS]== charT && mappingTtoS[charT]== charS)) {
                return false;
            }
        }

        return true;
    }
}
