import java.io.*;
import java.util.*;

public class Solution {

    private static int [][] cafes;
    private static int [] dx= {-1,1,1,-1};
    private static int [] dy= {1,1,-1,-1};
    private static int answer;

    private static boolean inside(int x, int y){
        return x>=0 && y>=0 && x< cafes.length && y< cafes.length;
    }
    private static void makeSquare(int x, int y, int w, int h){
        int[] desserts= new int[2*w+2*h-4];
        int idx=0;
        int nx= x;
        int ny= y;

        // 대각선 위 아래로 w, h 만큼 가도록
        for (int i = 1; i < w; i++) {
            nx+= dx[0];
            ny+= dy[0];

            // 좌표 벗어나면 w,h 크기 사각형 못만드니까 return
            if (!inside(nx,ny)) return;
            desserts[idx++]= cafes[nx][ny];
        }

        for (int i = 1; i < h; i++) {
            nx+= dx[1];
            ny+= dy[1];

            // 좌표 벗어나면 w,h 크기 사각형 못만드니까 return
            if (!inside(nx,ny)) return;
            desserts[idx++]= cafes[nx][ny];
        }

        for (int i = 1; i < w; i++) {
            nx+= dx[2];
            ny+= dy[2];

            // 좌표 벗어나면 w,h 크기 사각형 못만드니까 return
            if (!inside(nx,ny)) return;
            desserts[idx++]= cafes[nx][ny];
        }

        for (int i = 1; i < h; i++) {
            nx+= dx[3];
            ny+= dy[3];

            // 좌표 벗어나면 w,h 크기 사각형 못만드니까 return
            if (!inside(nx,ny)) return;
            desserts[idx++]= cafes[nx][ny];
        }

        int cnt= unique(desserts);
        answer= Math.max(answer, cnt);

    }

    private static int unique(int[] desserts) {
        List<Integer> list= new ArrayList<>();
        for (int dessert: desserts) {
            if (list.contains(dessert)) return -1;
            else list.add(dessert);
        }

        return desserts.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N= Integer.parseInt(br.readLine());
            cafes= new int[N][N];
            answer= -1;
            
            for (int i = 0; i < N; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cafes[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j <= N-i; j++) {
                    for (int w = 2; w < N; w++) {
                        for (int h = 2; h < N ; h++) makeSquare(i,j,w,h);
                    }
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");

        } // end of testcases

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main
}// end of class
