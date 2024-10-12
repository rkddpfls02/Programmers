import java.io.*;

public class Main  {

    public static void sort(int[] a){
        int heapSize= a.length-1;
        // 처음 상향힙 만들기
        for (int i= heapSize/2; i >0; i--){
            downheap(a,i,heapSize);
        }
        // 힙사이즈가 1이면 끝- 정렬할 요소가 하나 남은 것
        while(heapSize> 1){
            swap(a,1, heapSize--);
            downheap(a, 1, heapSize);
        }


    }
    public static void downheap(int[] a, int p, int heapSize){
        while(2*p <= heapSize){
            int s= 2*p;
            if (s< heapSize && isless(a[s],a[s+1])) s++;
            if(!isless(a[p],a[s])) break;
            swap(a,p,s);
            p= s;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isless(int i, int j) {
        return i < j;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int[] arr = new int[n+1];
        int k= Integer.parseInt(s[1]);
        s= br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }
        sort(arr);

        System.out.println(arr[k]);

    }
}