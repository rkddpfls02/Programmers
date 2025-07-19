import java.io.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        String s;
        while (!(s= br.readLine()).equals("0")){
            sb.append(isPalindrome(s)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static String isPalindrome(String s) {
        int start=0;
        int end= s.length()-1;

        while (start< end){
            if(s.charAt(start) != s.charAt(end)) return "no";
            start ++;
            end --;
        }
        return "yes";
    }
}
