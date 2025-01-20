import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken()); // 강의 수
        int m= Integer.parseInt(st.nextToken()); // 블루레이 수

        st= new StringTokenizer(br.readLine());
        int[] videos= new int[n] ;
        int min= 0, max=0;
        for (int i=0; i<n; i++) {
            int tmp=Integer.parseInt(st.nextToken());
            if(min<tmp) min= tmp; // 최소는 가장 용량이 큰 비디오
            max+= tmp;
            videos[i]= tmp;
        }
        int ans=0;

        while(min <= max){
            int mid= (min+max)/2;
            int sum=0;
            int blnum=1; //만들어진 블루레이 개수

            for(int video: videos) {
                if(sum+ video > mid) {
                    sum=video;
                    blnum++;
                }
                else sum += video;
            }

            // lower bound
            if(blnum<= m)  {
                max= mid-1; // m보다 작으면 크기를 줄여야함- 크기가 m과 같다면 크기가 젤 작은걸로
                ans= mid;
            }
            else min= mid+1; // m보다 크거나 같으면 크기를 늘려야함
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
