import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    static class User implements Comparable<User> {
        User (String name, int age, int order){
            this.name= name;
            this.age= age;
            this.order= order;
        }

        String name;
        int age;
        int order;

        @Override
        public int compareTo(User o) {
            if (this.age== o.age) return this.order- o.order;
            else return this.age- o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        String[] s;
        User[] users= new User[n];

        for(int i=0; i<n; i++) {
            s= br.readLine().split(" ");
            users[i]= new User(s[1],Integer.parseInt(s[0]),i);
        }

        Arrays.sort(users);

        Arrays.stream(users).forEach(user -> sb.append(user.age).append(" ").append(user.name).append("\n"));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
