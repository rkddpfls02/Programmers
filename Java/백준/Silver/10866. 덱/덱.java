import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n= Integer.parseInt(br.readLine());
        LinkedList<Integer> deque= new LinkedList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name= st.nextToken();

            switch (name) {
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;

                case "push_front":
                    deque.add(0, Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    System.out.println(deque.isEmpty() ? -1 : deque.remove(0));
                    break;

                case "pop_back":
                    System.out.println(deque.isEmpty() ? -1 : deque.remove(deque.size() - 1));
                    break;

                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.get(0));
                    break;

                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.get(deque.size() - 1));
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
            }

            }

    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
