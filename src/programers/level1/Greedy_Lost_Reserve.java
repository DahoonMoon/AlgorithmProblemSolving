package programers.level1;
import java.util.*;

public class Greedy_Lost_Reserve {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] map = new int[n + 2];
        Arrays.sort(lost);

        for(int i = 1; i <= n; i ++){
            map[i] = 1;
        }

        for(int i = 0; i < reserve.length; i++){
            map[reserve[i]]++;
        }

        for(int i = 0; i < lost.length; i++){
            map[lost[i]]--;
        }

        for(int i = 0; i < lost.length; i++){
            if(map[lost[i]] > 0){
                continue;
            }

            if(map[lost[i]-1] > 1){
                map[lost[i]]++;
                map[lost[i]-1]--;
            } else if(map[lost[i]+1]>1){
                map[lost[i]]++;
                map[lost[i]+1]--;
            }

        }

        for(int i = 0; i < map.length; i++){
            if(map[i] > 0){
                answer++;
            }
        }

        return answer;
    }
}
