import java.io.*;

public class Main {

    class City implements Comparable<City>{
        int cost;
        int meter;

        City(int cost, int meter){
            this.cost= cost;
            this.meter= meter;
        }

        @Override
        public int compareTo(City o) {
            return this.cost-o.cost;
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        String[] meter= br.readLine().split(" ");
        String[] cost= br.readLine().split(" ");

        // 마지막 도시는 어짜피 도착지니까 무시
        City[] citys= new City[n-1];
        int ans=0; // 총 가격

        for( int i=0; i<n-1; i++) {
            citys[i] = new City(Integer.parseInt(cost[i]),Integer.parseInt(meter[i]));
        }

        // 최소 cost 가진 도시 찾고 그 이후 meter 합 만큼 구매
        // 그 뒤 모두 무한대로 바꿔놓고 이 과정 반복
        // 무한대로 바꿔진 도시가 n-1이 되면 끝
        int index= n-1; //마지막 최소 인덱스 첨엔 n-1
        while(index!=0){
            int min= Integer.MAX_VALUE;
            int minindex=0; // 현재 최소 인덱스
            for(int i=0; i<index; i++){
                if( citys[i].cost <= min) {
                    minindex= i;
                    min= citys[i].cost;
                }
            }

            for(int i= minindex; i<index; i++) {
                ans += min * citys[i].meter;
            }

            index= minindex;
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
