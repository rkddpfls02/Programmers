import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int arr[] = new int[N];
        int sum=0;

        for(int i=0; i<N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for(int i=1; i<N; i++) {
                arr[i] = arr[i] + arr[i - 1];
        }

        for(int i=0; i<N; i++) {
            sum +=arr[i];
        }

        System.out.println(sum);



    }
}