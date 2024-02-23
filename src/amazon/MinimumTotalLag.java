package amazon;

import java.util.PriorityQueue;

public class MinimumTotalLag {

    public static void main(String[] args) {
        int[] centers= new int[]{1,2,2};
        int[] destinations= new int[]{5,2,4};
        System.out.println(getMinimumTotalLag(centers, destinations));
    }


    public static int getMinimumTotalLag (int[] centers, int[] destinations) {

        PriorityQueue<Integer> heap_centers= new PriorityQueue<>();

        PriorityQueue<Integer> heap_destinations = new PriorityQueue<>();

        for ( int center: centers) {
            heap_centers.add(center);
        }
        for (int destination: destinations) {
            heap_destinations.add(destination);
        }
        int sum=0;
        while ( ! heap_centers.isEmpty()) {
            sum += Math.abs(heap_centers.poll() - heap_destinations.poll());
        }
        return sum;
    }

}
