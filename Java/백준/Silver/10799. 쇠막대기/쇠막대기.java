import java.io.*;
import java.util.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> iron = new Stack<>();
        char c;
        int total=0;
        String s= br.readLine();
        for(int i=0; i<s.length(); i++){
            c= s.charAt(i);
            if (c== '(') iron.push(c);
            else if (iron.peek()=='(' && c==')') {
                iron.pop();
                iron.push('1');}
            else if(c==')'){
                int part=0;
                while (true){
                    c= iron.pop();
                    if (c=='('){
                        total += part+1;
                        iron.push((char)(part+48));
                        break;
                    }
                    else{
                        part+=c-48;
                    }
                }
            }
        }
        System.out.println(total);
}
}