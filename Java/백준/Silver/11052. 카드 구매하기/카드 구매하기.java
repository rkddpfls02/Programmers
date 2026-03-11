import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int[] p= new int[n+1]; // 1~n 장 카드 가격
        int [] dp= new int [n+1]; // 1~n 장 최대 가격

        String[] s= br.readLine().split(" ");
        for(int i=1; i<= n; i++) {
            p[i] = Integer.parseInt(s[i-1]);
            dp[i]= p[i];
        }


        for(int i= 1; i <= n; i++){
           for(int j= 1; j <= i/2; j++){
                dp[i]= Math.max(dp[i-j]+p[j],dp[i]);
           }
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
        br.close();

    }

    }
