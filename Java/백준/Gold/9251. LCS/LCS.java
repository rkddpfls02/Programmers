import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a= br.readLine().split("");
        String[] b= br.readLine().split("");
        int n= a.length;
        int m= b.length;
        int[][] ans= new int[n+1][m+1]; // 세로에 a를 가로에 b를 둘거임
        // i-1, j-1 이 0일 떄를 방지하기위해 해당값을 0으로 만들어 놓음
        for (int i=0; i<n; i++) ans[i][0]=0;
        for (int i=0; i<m; i++) ans[0][m]=0;

        for (int i=1; i<= n; i++){
            for (int j=1; j<= m; j++){
                if(a[i-1].equals(b[j-1])) ans[i][j]= ans[i-1][j-1]+1;
                else{
                    ans[i][j]= Math.max(ans[i-1][j], ans[i][j-1]);
                }
            }
        }

        System.out.println(ans[n][m]);

    }
}
