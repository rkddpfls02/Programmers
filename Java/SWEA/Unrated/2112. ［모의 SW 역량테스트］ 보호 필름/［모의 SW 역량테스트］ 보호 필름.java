import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int film[][], K, answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            st= new StringTokenizer(br.readLine());

            int D= Integer.parseInt(st.nextToken());
            int W= Integer.parseInt(st.nextToken());
            K= Integer.parseInt(st.nextToken());

            film= new int[D][W];

            for (int i = 0; i < D; i++) {
                st= new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) film[i][j]= Integer.parseInt(st.nextToken());
            }

            // 최악의 상태로 이거보다 더 많이 약품처리를 할 수 없음
            answer= K;

            if(check()){
                answer= 0; // dfs 안헀는데 이미
            } else {
                dfs(0,0);
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");

        } // end of testcases

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

    private static void dfs(int row, int cnt) {

        // 가지치기 - 왜냐면 나올수 있는 최대 값에서 줄여나가기 떄문에 중간까지 봤는데 이미 최적의 답을 넘기면 return
        if (cnt >= answer) return;

        if (row == film.length) {
            if(check()) {
                answer= cnt;
            }
            return;
        }

        int[] original= film[row].clone();
        // 아무처리 안한거
        dfs(row+1, cnt);

        // 1로 처리
        Arrays.fill(film[row],1);
        dfs(row+1, cnt+1);

        // 2로 처리
        Arrays.fill(film[row],0);
        dfs(row+1,cnt+1);

        // 백트레킹 원상복귀
        film[row]= original;

    }

    private static boolean check() {
        int cnt;
        boolean pass;

        for (int j = 0; j < film[0].length; j++) {
            // 한 열 마다 다시 체크
            pass= false;
            cnt= 1;
            for (int i = 1; i < film.length; i++) {
                if(film[i][j]== film[i-1][j]) cnt ++;
                else cnt = 1;

                if (cnt >= K) {
                    pass= true;
                    break;
                }
            }
            // 한 열이라도 통과 못하면 안됨
            if(!pass) return false;
        }

        return true;
    }
}// end of class

