import java.io.*;

public class Main {
    public static int recur_cnt=0;
    public static int dynamic_cnt=0;
    public static int recur_path(int[][] arr, int i, int j){

        if (i==-1 || j==-1) {
            recur_cnt ++;
            return 0;
        }
        else {
            return arr[i][j]+Math.max(recur_path(arr,i-1,j), recur_path(arr, i,j-1));
        }

    }

    public static int dynamic_path(int [][] arr, int n){
        int [][] max= new int[n][n];
        for (int i=0; i<n; i++){
            max[i][0]=0;
        }
        for (int i=0; i<n; i++){
            max[0][i]=0;
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int a= i-1;
                int b= j-1;
                if (a<0) a=0;
                if(b<0) b=0;
                max[i][j]= arr[i][j]+ Math.max(max[a][j], max[i][b]);
                dynamic_cnt++;
            }
        }
        return max[n-1][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s ;
        int[][] arr = new int[n][n];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        recur_path(arr, n-1,n-1);
        dynamic_path(arr,n);
        System.out.println(recur_cnt+" "+ dynamic_cnt);

    }

}