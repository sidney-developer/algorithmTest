package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _17_AmazonBooksRetail {

    public static void main(String[] args) {
        int[] books= new int[]{2,1,4,3};
        List<List<Integer>> retailBooks = getRetailBooks(books);
        for (List<Integer> retailBook: retailBooks) {
            for (int book: retailBook) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }

    // 把出现过 但是无法购买的书放到 小根堆里，用一个变量记住当前我能买的书，当小根堆中出现我能买的书后， 就弹出来记到当前 list 中，我能买的书 nextBook++
    // 继续看 小根堆是否有 下一本书；
    public static List<List<Integer>> getRetailBooks(int[] retailBooks) {

        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        List<List<Integer>> result= new ArrayList<>();
        int nextBook=1;

        for (int retailBook: retailBooks) {
            minHeap.add(retailBook);
            List<Integer> temp= new ArrayList<>();
            while (!minHeap.isEmpty() && minHeap.peek()==nextBook) {
                temp.add(minHeap.poll());
                nextBook++;
            }
            if (temp.isEmpty()) {
                temp.add(-1);
            }
            result.add(temp);
        }
        return  result;
    }

}
