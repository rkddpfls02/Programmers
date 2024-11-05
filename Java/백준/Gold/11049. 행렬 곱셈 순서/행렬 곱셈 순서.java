import java.io.*;

public class Main {
    public static void min(int[][] m, int i, int k){

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        // 행의수 열의 수 넣는 배열
        int[] matrix= new int[n+1];

        int[][] m= new int[n+1][n+1];
        String s=br.readLine();
        //0번째에 처음 행렬에 행 넣고 그 뒤에는 열에 해당되는 수만 넣을거임
        matrix[0]= Integer.parseInt(s.split(" ")[0]);
        matrix[1]= Integer.parseInt(s.split(" ")[1]);


        for(int i=1; i<n; i++) {
            matrix[i+1]= Integer.parseInt(br.readLine().split(" ")[1]);
            m[i][i]=0;
        }

        for(int r=1; r<n;r++){
            for (int i=1; i<=n-r; i++){
                m[i][i+r]= Integer.MAX_VALUE;

                for(int k=i; k<i+r; k++){
                    int cost = m[i][k] + m[k + 1][i+r] + (matrix[i - 1] * matrix[k] * matrix[i+r]);
                    m[i][i+r] = Math.min(m[i][i+r], cost);                }
            }
        }
        System.out.println(m[1][n]);

    }
}