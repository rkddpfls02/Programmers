import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 어짜피 버퍼로 읽어서 split된 개수만큼 집합에 넣을거라 첫줄 버림
        br.readLine();
        String[] s ;

        Set<Integer> a= new HashSet<>();
        Set<Integer> b= new HashSet<>();

        s= br.readLine().split(" ");
        for(String tmp: s) a.add(Integer.parseInt(tmp));

        s= br.readLine().split(" ");
        for(String tmp: s) b.add(Integer.parseInt(tmp));
        
        // Set 복제 이렇게
        Set<Integer> c = new HashSet<>(a);
        //a-b
        a.removeAll(b);
        // b-a
        b.removeAll(c);
        //두 차집합의 합집합
        a.addAll(b);

        System.out.println(a.size());
    }

}