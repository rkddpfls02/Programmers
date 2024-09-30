import java.io.*;
import java.util.LinkedList;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[] cnt = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        s = br.readLine();
        String name1 = s.split(" ")[0].toUpperCase();
        String name2 = s.split(" ")[1].toUpperCase();
        LinkedList<Integer> sum = new LinkedList<>();
        String maxname;
        int min ;
        int max ;
        if (n >= m) {
            maxname = name1;
            min = m;
            max= n;
        }
        else {
            maxname = name2;
            min = n;
            max = m;
        }
        
        for (int i = 0; i < min; i++) {
            sum.add(cnt[name1.charAt(i) - 'A']);
            sum.add(cnt[name2.charAt(i) - 'A']);
        }

        for (int i = min; i < max; i++) {
            sum.add(cnt[maxname.charAt(i)-'A']);
        }

        while (sum.size() !=2) {
            for (int i = 0; i < sum.size() - 1; i++) {
                int next = sum.get(1);
                int start = sum.remove();
                sum.addLast((start + next) % 10);
            }
            sum.remove();
        }

        System.out.println(sum.getFirst()*10 + sum.getLast()+"%");
    }
}