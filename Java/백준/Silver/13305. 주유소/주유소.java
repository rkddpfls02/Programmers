import java.io.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        String[] meter= br.readLine().split(" ");
        String[] cost= br.readLine().split(" ");

        long[] distance= new long[n-1];
        long[] costs= new long[n-1];


        // 마지막 도시는 어짜피 도착지니까 무시
        long ans=0; // 총 가격

        for( int i=0; i<n-1; i++) {
            distance[i]= Long.parseLong(meter[i]);
            costs[i]= Long.parseLong(cost[i]);
        }

        // 최소 cost로 계속 구매
        long min= costs[0];
        for(int i=0; i<n-1; i++){
                if(costs[i] <= min) {
                    min= costs[i];
                }
                ans += min * distance[i];
            }

        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
