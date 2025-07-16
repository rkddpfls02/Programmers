import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n= Integer.parseInt(br.readLine());
        Queue<Integer> queue= new LinkedList<>();

        for (int i=0; i<n; i++) queue.add(i+1);

        while (queue.size()!=1){
            queue.poll();
            if (queue.size()==1) break;
            queue.add(queue.poll());
        }

        bw.write(Integer.toString(queue.poll()));
        bw.flush();
        bw.close();

    }
}
