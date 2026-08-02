import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q;
        StringTokenizer st;
        int cnt;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            cnt= 0;
            int T= Integer.parseInt(br.readLine());

            q= new LinkedList<>();
            st= new StringTokenizer(br.readLine());

            for(int i=0; i<8; i++) q.offer(Integer.parseInt(st.nextToken()));

            while (!q.isEmpty()){

                int now = q.poll()- ((cnt++ % 5) +1);

                if(now <=0) {
                    q.offer(0);
                    break;
                }

                q.offer(now);

            }

            bw.write("#"+ test_case+" ");

            for (int num : q){
                bw.write(num+" ");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}