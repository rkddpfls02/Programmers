import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int m = Integer.parseInt(st.nextToken()); // 동생의 위치

        // If Su-bin is already at the same position as her sister
        if (n == m) {
            System.out.println(0);
            return;
        }

        // Maximum possible position to consider (based on problem constraints)
        int max = 100000;

        // BFS setup
        boolean[] visited = new boolean[max + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0}); // {current position, time taken}
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            // Check all possible moves
            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                // If we reach the target
                if (next == m) {
                    System.out.println(time + 1);
                    return;
                }

                // Add valid and unvisited positions to the queue
                if (next >= 0 && next <= max && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, time + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}