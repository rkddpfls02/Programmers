import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++){
            Deque<Integer> queue= new ArrayDeque<>();
            st= new StringTokenizer(br.readLine());
            int V= Integer.parseInt(st.nextToken());
            int E= Integer.parseInt(st.nextToken());

            // 진입차수 관리하는 배열필요
            int[] cnt= new int[V+1];
            // 엣지관리 List 배열 필요
            List<Integer>[] edges= new ArrayList[V+1];

            st= new StringTokenizer(br.readLine());

            // 빈 리스트 초기화
            for (int i = 1; i <= V; i++) {
                edges[i]= new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int start= Integer.parseInt(st.nextToken());
                int end= Integer.parseInt(st.nextToken());


                // 시작점 기준으로 연결된 다음 점 List로
                edges[start].add(end);

                // 진입차수 넣어줌
                cnt[end] ++;
            }


            for (int i = 1; i <= V; i++) {
                // 1. 진입차수가 0인 점 i를 먼저 찾음 - 큐에 넣음
                if(cnt[i]==0) {
                    queue.add(i);
                }

            }

            StringBuilder sb= new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            // 큐 빌때까지 함
            while(!queue.isEmpty()){
                int now= queue.pollFirst();
                sb.append(now).append(" ");
                List<Integer> adj= edges[now];

                // 인접한거 진입차수 하나 줄이면서 0인지 확인하고 0이면 출력
                for(int next : adj){
                    cnt[next]--;
                    if(cnt[next]==0) {
                        queue.addLast(next);
                    }

                }

                // 2. 진출간선 제거 근데 할 필요있나 이제 이 점은 안볼텐데 선행이라서
//                edges[now]= null;

            }

            bw.write(sb.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
