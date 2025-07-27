import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] s= br.readLine().split("");
            sb.append(isVPS(s)? "YES":"NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isVPS(String[] s) {
        Stack<String> stack= new Stack<>();
        for(String tmp: s){
            if(tmp.equals("(")) stack.add(tmp);
            else if (stack.isEmpty()) return false;
            else {
                if(!stack.pop().equals("(")) return false;
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }
}
