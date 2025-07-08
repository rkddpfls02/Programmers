import java.io.*;
import java.util.*;

public class Main {
//  이 문제에서 중요한건 indexof !!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb= new StringBuilder();

        LinkedList<Integer> queue= new LinkedList<>();
        String[] s= br.readLine().split(" ");

        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);
        int[] targets= new int[m];

        s= br.readLine().split(" ");
        for(int i=0; i< m; i++){
            targets[i]= Integer.parseInt(s[i]);
        }

        for (int i=1; i<= n; i++) queue.add(i);

        int cnt=0;
        for(int target: targets){
            int now= queue.indexOf(target);
            int mid= queue.size()/2;
            if(now>mid){
                for(int i=0; i< queue.size()-now;i++){
                    cnt++;
                    queue.offerFirst(queue.pollLast());
                }
            } else{
                for(int i=0; i< now;i++){
                    cnt++;
                    queue.offerLast(queue.poll());
                }
            }
            queue.poll();
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();

    }
}
