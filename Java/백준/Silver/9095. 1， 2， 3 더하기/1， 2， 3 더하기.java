import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb= new StringBuilder();

        int t= Integer.parseInt(br.readLine());
        int[] dp;
        for (int i=0; i<t; i++){
            int n= Integer.parseInt(br.readLine());
            dp= new int[n+1];
            dp[1]= 1;
            if(n>1) dp[2]= 2;
            if(n>2) dp[3]= 4;
            for(int j=4; j<=n; j++) dp[j]+= dp[j-1]+ dp[j-2]+ dp[j-3];
            sb.append(dp[n]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();

    }

}