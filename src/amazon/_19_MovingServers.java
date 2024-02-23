package amazon;

import java.util.Set;
import java.util.TreeSet;

public class _19_MovingServers {

    // Treeset
    public static int[] moveData ( int[] data, int[] moveFrom, int[] moveTo) {

        Set<Integer> set= new TreeSet<>();

        for (int i: data) {
            set.add(i);
        }
        int N= moveFrom.length;
        for (int i=0; i<N ; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        int[] ans= new int[set.size()];
        int index=0;
        for (int value: set) {
            ans[index++]= value;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {1, 7, 6, 8};
        int[] moveFrom = {1, 7, 2};
        int[] moveTo = {2, 9, 5};
        int[] ans= moveData(data, moveFrom, moveTo);
        for (int a: ans) {
            System.out.println(a);
        }
    }
}
