package aps.graphTraversal;

import java.util.*;

public class number_card_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            sb.append(map.getOrDefault(target, 0));

            if(i != m-1){
                sb.append(" ");
            }
        }

        System.out.print(sb.toString());

    }





}
