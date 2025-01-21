import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken()); // 수빈이
        int m= Integer.parseInt(st.nextToken()); // 동생

        if (n==m) {
            System.out.println(0);
            return;
        }

        int max= 100000;

        boolean[] visited= new boolean[max+1]; //0부터 max까지
        Arrays.fill(visited, false);

        Queue<int[]> q= new LinkedList<>();
        int[] nexts= new int[3];
        q.add(new int[]{n,0});

        while(!q.isEmpty()){
            int[] now= q.remove();
            int num= now[0];
            int time= now[1];

            nexts[0]= num-1;
            nexts[1]= num+1;
            nexts[2]= num*2;

            for(int next: nexts){
                if(next== m){
                    System.out.println(time+1);
                    return;
                }

                if (next>=0 && next<= max && !visited[next]) {
                    q.add(new int[]{next, time+1});
                    visited[next]= true;
                }
                // 조건 중 앞에서 하나라도 false면 뒤에 평가 안함
                // 따라서 visited 조건 체크가 마지막 조건으로 와야함
            }

        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
