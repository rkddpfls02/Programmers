import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        String[] s= br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);

        String[][] campus= new String[n][m];
        boolean[][] visited= new boolean[n][m];

        // 시작 x,y 좌표
        int[] start = new int[2];
        for (int i=0; i<n; i++){
            s= br.readLine().split("");
            Arrays.fill(visited[i], false);
            for (int j=0; j<m; j++){
                if (s[j].equals("I")) start= new int[]{i, j};
                campus[i][j]= s[j];
            }
        }

        dfs(start[0],start[1], campus, visited);

        bw.write(cnt==0? "TT": Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, String[][] campus, boolean[][] visited) {
        int[] dx= {0,1,0,-1};
        int[] dy= {1,0,-1,-0};
        visited[x][y] = true;

        if (campus[x][y].equals("P")) cnt++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < campus.length && ny < campus[0].length) {
                if(!campus[nx][ny].equals("X") && !visited[nx][ny]) {
                    dfs(nx, ny, campus, visited);
                }
            }
        }

    }

}
