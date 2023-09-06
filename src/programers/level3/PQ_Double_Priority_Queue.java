package programers.level3;

import java.util.*;

public class PQ_Double_Priority_Queue {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++){
            String[] op = operations[i].split(" ");
            if(op[0].equals("I")){
                minHeap.offer(Integer.valueOf(op[1]));
                maxHeap.offer(Integer.valueOf(op[1]));
            } else if(op[0].equals("D") && op[1].equals("1") && minHeap.size() > 0) {
                int max = maxHeap.poll();
                minHeap.remove(max);
            } else if(op[0].equals("D") && op[1].equals("-1") && maxHeap.size() > 0) {
                int min = minHeap.poll();
                maxHeap.remove(min);
            }
        }

        if(minHeap.size() > 0){
            return new int[]{maxHeap.poll(), minHeap.poll()};
        } else {
            return new int[]{0, 0};
        }
    }
}
