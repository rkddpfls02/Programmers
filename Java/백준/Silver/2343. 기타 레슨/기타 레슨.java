import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 비디오 개수
        int m = Integer.parseInt(st.nextToken()); // 블루레이 개수

        st = new StringTokenizer(br.readLine());
        List<Long> videos = new ArrayList<>();

        long max = 0; // 비디오 길이 합
        long min = 0; // 가장 긴 비디오의 길이

        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(st.nextToken());
            videos.add(tmp);
            max += tmp;
            min = Math.max(min, tmp); // 가장 긴 비디오의 길이
        }

        long result = max;

        // 이진 탐색
        while (min <= max) {
            long capacity = (min + max) / 2; // 블루레이 용량
            if (canDivide(videos, capacity, m)) {
                result = capacity;
                max = capacity - 1;
            } else {
                min = capacity + 1;
            }
        }

        bw.write(Long.toString(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 주어진 용량(capacity)으로 m개의 블루레이로 나눌 수 있는지 확인하는 함수
    private boolean canDivide(List<Long> videos, long capacity, int m) {
        long sum = 0;
        int count = 1; // 블루레이 개수

        for (long video : videos) {
            if (sum + video > capacity) {
                count++;
                sum = video; // 새로운 블루레이 시작
                if (count > m) return false;
            } else {
                sum += video;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}