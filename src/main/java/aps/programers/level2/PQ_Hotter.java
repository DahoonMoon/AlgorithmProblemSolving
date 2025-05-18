package aps.programers.level2;
import java.util.*;

public class PQ_Hotter {
    static int globalMin;

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        int globalMin = pq.peek();

        while(globalMin < K && pq.size() > 1){
            int min = pq.poll();
            int second = pq.poll();
            if(second == 0){
                return -1;
            }

            pq.offer(min + second*2);

            if(pq.size() ==1 && pq.peek() < K){
                return -1;
            }

            globalMin = pq.peek();
            answer++;
        }

        return answer;
    }
}
