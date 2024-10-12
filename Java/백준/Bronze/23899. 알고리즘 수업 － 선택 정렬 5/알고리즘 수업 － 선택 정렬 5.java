import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s= br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        int[] b = new int[n];
        s= br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(s[i]);
        }

        for (int i=n-1; i >=0; i--){
            int max= i;
            // 같은지 검사 어짜피 이중for문이라 시간복잡도 차이 없음
            boolean isequal= true;
            for (int j= 0; j < n; j++){
                if(a[j] != b[j]) isequal= false;
            }
            if(isequal) {
                System.out.println(1);
                return;
            }

            for (int j= 0; j < i; j++){
                if (a[j] > a[max]) max= j;
            }

            int temp= a[i];
            a[i]= a[max];
            a[max]= temp;

        }
        System.out.println(0);

    }
}