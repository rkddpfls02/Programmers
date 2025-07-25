import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        String[] s;

        int cases= Integer.parseInt(br.readLine());

        // test 만큼 돌아야함
        for(int i=0; i< cases; i++){
            s= br.readLine().split(" ");
            int n= Integer.parseInt(s[0]);
            int m= Integer.parseInt(s[1]);

            s= br.readLine().split(" ");
            int[] important= new int[n];
            int[] cnt= new int[10]; // 각 중요도 1~9 각각 몇개 있는지
            Arrays.fill(cnt,0);

            Queue<Integer> queue= new LinkedList<>();

            for (int j=0; j<n; j++){
                queue.add(j);
                int tmp= Integer.parseInt(s[j]);
                important[j]= tmp; // 중요도 저장
                cnt[tmp] ++; // 중요도 개수 추가
            }

            sb.append(findPrint(queue, important, cnt,  m)).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static int findPrint(Queue<Integer> queue, int[] important, int[] cnt, int m) {
        int ans=0;
        while(!queue.isEmpty()){
            boolean isImportant= true;
            int now= queue.poll();
            int tmp= important[now]; // 현재 중요도

            for(int i= tmp+1; i<=9; i++){ // 그거보다 큰 증요도가 있는지
                if(cnt[i] !=0) { // 더 높은 우선순위 존재
                    isImportant= false;
                    break;
                }
            }


            if (isImportant) {
                cnt[tmp]--; // 프린트는 맞는데 찾고자하는 대상이 아닐 때 제거만함
                ans++;
                if(now== m) return ans;
            }
            else queue.offer(now); // 맨뒤로 넣기

        }
        return ans;
    }
}
