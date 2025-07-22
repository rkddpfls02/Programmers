import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder("<");
        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        Deque<Integer> deque= new ArrayDeque<>();

        for (int i=0; i<n; i++) deque.add(i+1);

        while (!deque.isEmpty()){
            for(int i=0; i<k-1; i++) deque.offerLast(deque.poll());
            sb.append(deque.poll()).append(", ");
        }

        bw.write(sb.substring(0,sb.length()-2)+">");
        bw.flush();
        bw.close();
        br.close();
    }
}
