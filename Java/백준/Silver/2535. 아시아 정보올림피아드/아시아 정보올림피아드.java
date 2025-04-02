import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer,int[]> players= new HashMap<>();

        String[] s;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            players.put(Integer.parseInt(s[2]), new int[] {Integer.parseInt(s[0]),Integer.parseInt(s[1])});
        }

        // 맵 키만 뽑아서 배열로
        Integer[] scores = players.keySet().toArray(new Integer[0]);

        // 삽입정렬
        for(int i=1; i< n; i++){
            int newItem= scores[i];
            int j= i-1;
            while(j>=0 && newItem>scores[j]){
                scores[j+1]= scores[j];
                j--;
            }
            scores[j+1]= newItem;
        }

        int[][] winners= {players.get(scores[0]), players.get(scores[1]), players.get(scores[2])};
        int first= winners[0][0];

        // 2등, 3등의 나라가 1등과 같다면 3등 다를 때까지 탐색
        if(winners[1][0]== first && winners[2][0]== first){
            int i=3;
            do {
                winners[2]= players.get(scores[i]);
                i++;
            }
            while (winners[2][0]== first);
        }

        for(int[] winner: winners) bw.write(winner[0]+" "+winner[1]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
        public static void main (String[]args) throws IOException {
            new Main().solution();

    }
}