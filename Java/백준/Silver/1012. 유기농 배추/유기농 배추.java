import java.io.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        String[] s; // 읽을 때 필요
        int n, m, k, sum; // 차례로 가로 세로 배추 수 정답
        int[][] arr; // 배추 심어져 있는 배열
        StringBuilder ans = new StringBuilder();

        for (int i= 0; i< t; i++) {
            s= br.readLine().split(" ");
            n= Integer.parseInt(s[0]);
            m= Integer.parseInt(s[1]);
            k= Integer.parseInt(s[2]);
            sum=0;
            arr= new int[n][m];

            for (int j = 0; j < k; j++) {
                s = br.readLine().split(" ");
                arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            }

            for (int l=0; l<n; l++){
                for (int j=0; j<m; j++){
                    if(arr[l][j]==1) {
                        bfs(arr, l,j);
                        sum ++;
                    }
                }
            }
            ans.append(sum).append("\n");
        }

        System.out.print(ans);
    }

    private static void bfs(int[][] arr , int l, int j) {
        LinkedList<int[]> q= new LinkedList<>();
        int [] index;
        arr[l][j] = 0;
        q.add(new int[]{l,j});

        while(!q.isEmpty()){
            index= q.pop();
            l= index[0];
            j= index[1];
            if(l==0){
                if (arr[l+1][j]==1) {
                    arr[l+1][j]=0;
                    q.add(new int[]{l+1, j });
                }
            }
            else if(l==arr.length-1){
                if (arr[l-1][j]==1){
                    arr[l-1][j]=0;
                    q.add(new int[]{l-1, j});
                }
            }
            else {
                if (arr[l+1][j]==1) {
                    arr[l+1][j]=0;
                    q.add(new int[]{l+1, j});
                }
                if (arr[l-1][j]==1){
                    arr[l-1][j]=0;
                    q.add(new int[]{l-1, j});
                }
            }

            if(j==0){
                if (arr[l][j+1]==1) {
                    arr[l][j+1]=0;
                    q.add(new int[]{l, j+1});
                }
            }
            else if(j==arr[l].length-1){
                if (arr[l][j-1]==1){
                    arr[l][j-1]=0;
                    q.add(new int[]{l, j-1});
                }
            }
            else {
                if (arr[l][j+1]==1) {
                    arr[l][j+1]=0;
                    q.add(new int[]{l, j+1 });
                }
                if (arr[l][j-1]==1){
                    arr[l][j-1]=0;
                    q.add(new int[]{l, j-1});
                }
            }
        }
    }
}