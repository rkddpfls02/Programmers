import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());

        String[] s;

        for (int i=0; i<t; i++) {
            int n= Integer.parseInt(br.readLine());
            s= br.readLine().split(" ");
            Set<Integer> noteSet= new HashSet<>(); // 여러번 봐도 하나로 취급
            for (int j=0; j<n; j++) noteSet.add(Integer.parseInt(s[j]));
            List<Integer> note= new ArrayList<>(noteSet);
            Collections.sort(note);
            n= Integer.parseInt(br.readLine());
            s= br.readLine().split(" ");
            for (int j=0; j<n; j++) bw.write(Integer.toString(binarySearch(Integer.parseInt(s[j]),note))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int binarySearch(int num, List<Integer> note) {
        int mid= note.size()/2;
        if (note.isEmpty()) return 0;
        if (note.get(mid)==num) return 1;
        else if (note.get(mid)>num) return binarySearch(num, note.subList(0,mid));
        else return binarySearch(num, note.subList(mid+1,note.size()));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
