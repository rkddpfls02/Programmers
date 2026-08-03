import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx= {0, 0, -1, 1}; 
        int[] dy= {1, -1, 0, 0};

        for(int test_case = 1; test_case <= 10; test_case++) {
            Queue<int []> q= new LinkedList<>();
            boolean answer= false;
            int[][] arr= new int[16][16];
            int T= Integer.parseInt(br.readLine());
            boolean visited[][] = new boolean[16][16];

            for (int i = 0; i < arr.length; i++) {
                String[] s= br.readLine().split("");
                for(int j=0; j< s.length; j++) arr[i][j]= Integer.parseInt(s[j]);
            }

            q.add(new int[]{1,1});
            visited[1][1]= true;

            while (!q.isEmpty()){
                int[] now= q.poll();

                if(answer) break;

                for (int i = 0; i < dx.length; i++) {
                    int x= now[0]+dx[i];
                    int y= now[1]+dy[i];

                    if(x >=0 && y >=0 && x< arr.length && y< arr.length) {

                        if(arr[x][y]== 3){
                            answer= true;
                            break;
                        }

                        if(arr[x][y]== 0 && !visited[x][y]){
                            visited[x][y]= true;
                            q.add(new int[]{x,y});
                        }

                    }

                }

            }

            bw.write("#"+ test_case+" "+ (answer? 1:0));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}