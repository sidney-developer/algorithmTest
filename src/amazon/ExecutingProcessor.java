package amazon;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.HashMap;

public class ExecutingProcessor {

    public static void main(String[] args) {
        int[] array= new int[]{5,5,3,6,5,3};
        System.out.println(getExecutingProcessorResult(array));
        int[] array2= new int[]{4,3,3,3};
        System.out.println(getExecutingProcessorResult(array2));
        int[] array3= new int[]{5, 8, 4, 4 ,8, 2};
        System.out.println(getExecutingProcessorResult(array3));
    }

    //Hash map<int,int>, key是值，value是当前的值。遍历数组，每当key再出现一次，先加一次当前value，然后把当前value变为ceil(key)/2。
    public  static  int getExecutingProcessorResult (int[] executions) {

        HashMap<Integer, Integer> map= new HashMap<>();

        int res=0;
        for (int execution: executions) {
            if (!map.containsKey(execution)) {
                map.put(execution, execution);
            }else {
                int temp = map.get(execution);
                temp = temp / 2 + (temp / 2 * 2 == temp ? 0 : 1);
                map.put(execution, temp);
            }
            res += map.get(execution);
        }
        return  res;
    }
}
