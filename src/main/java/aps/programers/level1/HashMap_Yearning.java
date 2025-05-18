package aps.programers.level1;
import java.util.*;

public class HashMap_Yearning {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }

        // System.out.println(map);

        for(int i = 0; i < photo.length; i++){
            int temp = 0;
            for(int j = 0; j < photo[i].length; j++){
                if(map.get(photo[i][j]) != null) {
                    temp += map.get(photo[i][j]);
                }
            }
            answer[i] = temp;
        }

        return answer;
    }
}
