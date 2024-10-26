import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        String[] temp= bf.readLine().split(" ");
        Set<Integer> myCard = new HashSet<>();
        for(int i=0; i < n; i++) myCard.add(Integer.parseInt(temp[i]));
        int m= Integer.parseInt(bf.readLine());
        temp= bf.readLine().split(" ");
        for(int i=0; i < m; i++){
            if (myCard.contains(Integer.parseInt(temp[i])))
                System.out.print(1+" ");
            else System.out.print(0+" ");
        }
        


    }

}