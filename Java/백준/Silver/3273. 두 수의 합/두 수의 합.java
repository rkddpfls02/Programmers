import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());

        int[] nums= Arrays.stream(br.readLine().split(" ")) // String 타입 Stream을 만듦
                .mapToInt(Integer::parseInt) // 얘가 IntStream을 리턴함
                .sorted() // 정렬
                .toArray();

        int target= Integer.parseInt(br.readLine());

        int start= 0;
        int end= n-1;
        int cnt=0;

        while (start<end && start< n && end< n){
            int now= nums[start]+nums[end];
            if(now<target) start ++;
            else if (now> target) end --;
            else {
                cnt ++;
//                start++;
                end--;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();



    }

}