import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] s;

        int n = Integer.parseInt(br.readLine());
        int [][] price= new int[n][3];
        int [][] dp= new int[n][3]; // 길이가 n인 계단 수

        for(int i=0 ; i< n; i++) {
            s= br.readLine().split(" ");
            price[i][0]= Integer.parseInt(s[0]);
            price[i][1]= Integer.parseInt(s[1]);
            price[i][2]= Integer.parseInt(s[2]);

            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[0][0]= price[0][0];
        dp[0][1]= price[0][1];
        dp[0][2]= price[0][2];

        for(int i=1 ; i<n; i++){ // n 번째 집
            for(int j=0; j< 3; j++){ // 0 R 1 G 2 B
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.min(price[i][j] + dp[i - 1][k], dp[i][j]);
                }
            }
        }


        int min= Integer.MAX_VALUE;
        for(int i=0; i< 3; i++) {
            min= Math.min(dp[n-1][i], min);
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();

    }

    }
