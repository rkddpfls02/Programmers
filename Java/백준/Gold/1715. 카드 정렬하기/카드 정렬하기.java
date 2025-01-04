import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int a,b;
        int c=0;
        int sum=0;
        Queue<Integer> queue= new PriorityQueue<>();

        for(int i=0; i<n; i++) queue.add(Integer.parseInt(br.readLine()));

        while(queue.size()!=1){
            a= queue.remove();
            b= queue.remove();
            c= a+b;
            sum +=c;
            queue.add(c);
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
