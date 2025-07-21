import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        int now=0;
        boolean isStack= true;

        Stack<Integer> stack= new Stack<>();

        for (int i=0; i<n; i++){
            int num= Integer.parseInt(br.readLine());
            if (now< num) {
                while (now != num){
                    stack.add(++now);
                    sb.append("+").append("\n");
                }
            }

            if (stack.peek()==num) {
                stack.pop();
                sb.append("-").append("\n");
            }
            else{
                isStack= false;
                break;
            }

        }

        bw.write(isStack? sb.toString(): "NO");
        bw.flush();
        bw.close();

    }
}
