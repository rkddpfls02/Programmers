import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int[] dp= new int[n];
        dp[0]= 1;
        if(n>1) dp[1]= 2;

        for (int i=2; i<n; i++){ // n 길이
            dp[i]+= (dp[i-1]+dp[i-2]) %15746;
        }

        bw.write(Integer.toString(dp[n-1] %15746));
        bw.flush();

    }

}