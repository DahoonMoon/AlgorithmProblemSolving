package programers.level2;
import java.util.*;

public class Tower_Of_Hanoi {
    static List<List<Integer>> result;

    public int[][] solution(int n) {
        result = new LinkedList<>(new LinkedList<>());

        hanoi(n, 1, 2, 3);

        int[][] answer = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++){
            answer[i][0] = result.get(i).get(0);
            answer[i][1] = result.get(i).get(1);
        }

        return answer;
    }

    void hanoi(int n, int start, int mid, int target){

        if(n == 1){
            result.add(List.of(start, target));
            return;
        }

        // n-1 개를 start에서 mid로 옮긴다
        hanoi(n-1, start, target, mid);

        // 1 개를 start에서 target으로 옮긴다
        result.add(List.of(start, target));

        // n-1 개를 mid에서 target으로 옮긴다.
        hanoi(n-1, mid, start, target);

    }
}
