package aps.programers.level2;
import java.util.*;

public class BFS_Comback_Home {
        static int[] visit;

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            //map 그리기
            List<List<Integer>> map = new ArrayList<>();
            for(int i = 0; i < n+1; i++){
                map.add(new ArrayList<>());
            }

            for(int i = 0; i < roads.length; i++){
                map.get(roads[i][0]).add(roads[i][1]);
                map.get(roads[i][1]).add(roads[i][0]);
            }

            //destination에서 반대로 bfs
            visit = new int[n + 1];
            for(int j = 0; j <= n; j++){
                visit[j] = -1;
            }
            bfs(destination, map);

            for(int i = 0; i < sources.length; i++){
                answer[i] = visit[sources[i]];
            }

            //답변
            return answer;
        }

        void bfs(int now, List<List<Integer>> map){
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(now);
            visit[now] = 0;

            while(!queue.isEmpty()){
                int next = queue.poll();

                for(int i : map.get(next)){
                    if(visit[i] == -1){
                        visit[i] = visit[next] + 1;
                        queue.offer(i);
                    }
                }
            }
        }

}
