import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N= Integer.parseInt(br.readLine());
            String[] cards= br.readLine().split(" ");

            Deque<String> dq1= new ArrayDeque<>();
            Deque<String> dq2= new ArrayDeque<>();

            int mid= N%2==0? N/2-1: N/2;

            for (int i = 0; i <= mid; i++) dq1.offerLast(cards[i]);
            for (int i = mid+1; i < N; i++) dq2.offerLast(cards[i]);

            sb.append("#").append(test_case).append(" ");

            while (!dq2.isEmpty()){
                sb.append(dq1.pollFirst()).append(" ");
                sb.append(dq2.pollFirst()).append(" ");
            }

            if (!dq1.isEmpty()) sb.append(dq1.pollFirst());
            sb.append("\n");

        } // end of testcases

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main
}// end of class
