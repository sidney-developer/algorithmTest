package amazon;

public class minimumNumberofSwaps {

    public static void main(String[] args) {
        System.out.println(getMinimumSwaps("0100101"));
    }

    // two pointers
    public static int getMinimumSwaps (String binary) {

        char[] chs= binary.toCharArray();
        int left=0;
        int right= chs.length-1;
        int N= chs.length;
        int difference=0;
        while (left < right) {
            if (chs[left] != chs[right]) {
                difference++;
            }
            left++;
            right--;
        }
        return difference % 2==0 ? difference/2 : (N%2 ==1? difference/2 +1 : -1 );
    }

}
