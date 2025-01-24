import java.util.*;
 
public class Main {    
 
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        
        int year = 0;
        while(true) {
            int iceburge = countIceburge(); 
            if(iceburge >= 2) break; 
            else if(iceburge == 0) {
                year = 0;
                break;
            }
            melting(); 
            year++;
        }
        
        System.out.println(year);
    }
    
    public static void melting() {
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] memo = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != 0) {
                    q.offer(new int[] {i, j});
                    memo[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int count = 0;
            int[] node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!memo[nx][ny] && board[nx][ny] == 0) count++;
                }
            }
            if(board[node[0]][node[1]] < count) board[node[0]][node[1]] = 0;
            else board[node[0]][node[1]] -= count;
            
        }
    }
    
    public static int countIceburge() {
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(board[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }
}