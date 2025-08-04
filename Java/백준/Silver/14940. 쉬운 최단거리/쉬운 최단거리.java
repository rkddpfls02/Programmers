import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dist;
    static int x; // 목적지의 x좌표
    static int y; // 목적지의 y좌표


    public static void main(String[] args) throws IOException {
        String [] s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);


        int[][] map= new int [n][m];
        dist= new int[n][m];

        for(int i=0; i<n; i++) {
            s= br.readLine().split(" ");
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            
            for(int j=0; j<m; j++){
                if(s[j].equals("2")) {
                    x= i;
                    y= j;
                }
                map[i][j]= Integer.parseInt(s[j]);
            }
        }

        bfs(map);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]== 0) bw.write("0 ");
                else if(dist[i][j]== Integer.MAX_VALUE) bw.write("-1 ");
                else bw.write(dist[i][j]+" ");
            }

            bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(int[][] map) {
        int[] dx= {0,0,1,-1};
        int[] dy={1,-1,0,0};

        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] {x,y});
        dist[x][y]=0;

        while (!queue.isEmpty()){
            int [] now= queue.poll();
            int cx= now[0]; // 현재 좌표
            int cy= now[1];

            for(int k=0; k<4; k++){
                int nx= now[0] +dx[k];
                int ny= now[1] +dy[k];
                if(nx< map.length && ny< map[0].length && nx>=0 && ny>=0 && map[nx][ny] ==1){
                    if(dist[nx][ny]> dist[cx][cy]+1) { // 현재 +1 한게 넣고자 하는 애 보다 작으면 넣음
                        dist[nx][ny]= dist[cx][cy]+1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
