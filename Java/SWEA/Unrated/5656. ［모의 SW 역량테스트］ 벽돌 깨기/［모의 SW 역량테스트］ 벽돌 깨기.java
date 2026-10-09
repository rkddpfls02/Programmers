import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] map;
    private static int [][] init;
    private static boolean[] visited;
    private static int n;
    private static int min;

    private static void selectCol(int depth, int[] choice){
        if(depth== n){
            breakBrick(choice);
            return;
        }

        for (int j = 0; j < map[0].length; j++) {
            choice[depth]= j;
            visited[j]= true;
            selectCol(depth+1,choice);
            visited[j]= false;
        }


    }

    private static void breakBrick(int[] choice) {
        // 그 행에서 터질 벽돌 찾아서 터트림
        int row=0;
        for (int c: choice){
            boolean findbrick= false;

            for (int r = 0; r < map.length; r++) {
                if (map[r][c] != 0) {
                    row= r;
                    findbrick= true;
                    break;
                }
            }

            if(findbrick) {
                shoot(row,c);
                downBrick();
            }
        }

        int cnt=0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]!=0) cnt++;
            }
        }

        min= Math.min(min, cnt);

        // 다른 상태 보기 위해 처음 상태로 되돌려주기
        for (int i = 0; i < map.length; i++) {
            map[i]= Arrays.copyOf(init[i],init[i].length);
        }

    }

    private static void downBrick() {
        int row= map.length-1;

        // 모든 열에 대하여
        for (int j = 0; j < map[0].length; j++) {
            // 마지막 행-1부터 0까지
            for (int i = row-1; i>= 0; i--) {

                int tmp= map[i][j];
                int changeIdx= row;

                // 아래로 내려가면서 숫자 나오기 전과 바꿈
                for (int k = i+1; k <= row; k++) {
                    if (map[k][j]!=0) {
                        changeIdx= k-1;
                        break;
                    }
                }
                if (changeIdx==i) continue;
                map[changeIdx][j]= tmp;
                map[i][j]= 0;

            }

        }
    }

    private static void shoot(int row, int c) {

        int[] dx= {0, 0, 1, -1}; // 상 하 좌 우
        int[] dy= {1, -1, 0, 0};
        int num= map[row][c];

        // 자신 0으로 만듦
        map[row][c]= 0;

        for (int dir = 0; dir < dx.length; dir++) {
            int nr= row;
            int nc= c;
            for (int i = 1; i < num; i++) {
                nr+= dx[dir];
                nc+= dy[dir];
                if (inside(nr, nc) && map[nr][nc]!=0){
                    if (map[nr][nc]== 1) map[nr][nc]=0;
                    else shoot(nr,nc);
                }

            }
        }

    }

    private static boolean inside(int nr, int nc) {
        return nr >=0 && nc >=0 && nr < map.length && nc < map[0].length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;


        for (int testcase = 1; testcase <= T; testcase++) {
            min= Integer.MAX_VALUE;
            st= new StringTokenizer(br.readLine());
            n= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            int h= Integer.parseInt(st.nextToken());

            map= new int[h][w];
            init= new int[h][w];
            visited= new boolean[w];

            for (int i = 0; i < h; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j]= Integer.parseInt(st.nextToken());
                    init[i][j]= map[i][j];
                }
            }

            // 4개의 열을 골라서 구슬 쏘기
            selectCol(0,new int[n]);

            sb.append("#").append(testcase).append(" ").append(min).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
