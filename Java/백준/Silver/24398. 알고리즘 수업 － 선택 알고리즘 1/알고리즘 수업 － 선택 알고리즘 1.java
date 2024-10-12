import java.io.*;

public class Main {
    static int cnt = 0;  // 교환 횟수 카운트
    static int K;        // K번째 교환을 추적하기 위한 값

    // 배열을 분할하는 partition 함수
    private static int partition(int[] a, int low, int high) {
        int i = low - 1;
        int pivot = a[high]; // 피벗은 마지막 원소로 설정
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j); // 피벗보다 작은 경우 교환
            }
        }
        // 피벗을 올바른 위치에 놓기 위한 마지막 교환
        if (i + 1 != high) swap(a, i + 1, high);
        return i + 1; // 피벗의 최종 위치 반환
    }

    private static void swap(int[] a, int i, int j) {
        cnt++; 
        if (cnt == K) {
            System.out.println(Math.min(a[i], a[j]) + " " + Math.max(a[i], a[j]));
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int select(int[] a, int low, int high, int q) {
        if (low == high) return a[low]; // 배열에 하나만 남았을 때
        int t = partition(a, low, high);
        int k = t - low + 1; // 피벗이 전체에서 몇 번째인지 계산
        if (k > q) {
            return select(a, low, t - 1, q); // 왼쪽 부분 배열에서 찾기
        } else if (k == q) {
            return a[t]; // 피벗이 q번째 원소일 때
        } else {
            return select(a, t + 1, high, q - k); // 오른쪽 부분 배열에서 찾기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]) - 1;
        K = Integer.parseInt(s[2]);

        int[] a = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        select(a, 0, n - 1, q);

        if (cnt < K) System.out.println(-1);
    }
}
