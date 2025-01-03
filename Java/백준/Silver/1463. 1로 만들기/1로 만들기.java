import java.io.*;

public class Main {

    public int min(int a, int b, int c){
        if (a>b){
            return Math.min(b, c);
        }
        else return Math.min(a, c);
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int a,b,c;
        int [] dp= new int[n+1];
        
        dp[0]=Integer.MAX_VALUE; //나누어 떨어지지 않으면 무한대로 설정
        dp[1]=0; //1이 1이될려면 0번
        
        for (int i=2; i<=n;i++){
            a=0;
            b=0;
            c=i-1;
            if(i%3==0) a= i/3;
            if (i%2==0) b= i/2;
            dp[i]= min(dp[a],dp[b],dp[c])+1;
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
