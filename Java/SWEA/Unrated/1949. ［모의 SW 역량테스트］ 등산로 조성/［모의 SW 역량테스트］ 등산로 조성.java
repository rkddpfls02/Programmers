
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int [] dx= {0, 0, -1, 1};
    private static int [] dy= {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;

    private static void findRoute (int r, int c, int K, int cnt){

        answer= Math.max(answer, cnt);

        for (int dir = 0; dir < dx.length; dir++) {
            int nr= r+ dx[dir];
            int nc= c+ dy[dir];

            if(!inside(nr,nc) || visited[nr][nc]) continue;

            // 다음으로 갈 수 있는지 확인하고 가기
            int now= map[r][c];
            int next= map[nr][nc];

            if (now > next) {
                visited[nr][nc]= true;
                findRoute(nr, nc, K, cnt +1);
            }
            else if (next -(now -1) <= K){
                map[nr][nc]= now -1;
                visited[nr][nc]= true;
                findRoute(nr, nc, 0, cnt+1);
                map[nr][nc]= next;
            }

            visited[nr][nc]= false;

        }
    }

    private static boolean inside (int r, int c){
        return r >=0 && c>= 0 && r< map.length && c< map.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            answer= 0;
            st= new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            int K= Integer.parseInt(st.nextToken());
            map= new int[N][N];
            visited= new boolean[N][N];

            int max= Integer.MIN_VALUE;
            List<int[]> starts= new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j]= Integer.parseInt(st.nextToken());
                    max= Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) if(map[i][j]== max) starts.add(new int[]{i,j});
            }

            for (int[] start: starts) {
                visited[start[0]][start[1]]= true;
                findRoute(start[0], start[1], K, 1);
                visited[start[0]][start[1]]= false;
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");

        } // end of testcases

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main
}// end of class
