import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int m = 1000000000;

        // i에서부터 시작한 j길이 계단수 개수
        int[][] stair = new int[10][n + 1];
        
        // 길이가 1 
        for (int i = 0; i < 10; i++) {
            stair[i][1] = 1; 
        }
        
        // 길이가 2 이상
        for (int j = 2; j <= n; j++) { 
            for (int i = 0; i < 10; i++) {
                if (i == 0) stair[i][j] = stair[1][j - 1] % m;
                else if (i == 9) stair[i][j] = stair[8][j - 1] % m;
                else stair[i][j] = (stair[i + 1][j - 1] + stair[i - 1][j - 1]) % m;
            }
        }

        for (int i = 1; i < 10; i++) ans = (ans + stair[i][n]) % m;

        System.out.println(ans);
    }
}
