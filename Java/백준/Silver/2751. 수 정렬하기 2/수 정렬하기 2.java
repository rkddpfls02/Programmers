import java.io.*;

public class Main  {
    private static void merge(int[] a,int[] b, int low, int mid, int high){
        int i= low, j= mid +1;
        for (int k= low; k<= high; k++){
            // 앞쪽 배열이 먼저 다 소진되면 뒤에꺼 넣기
            if (i> mid) b[k]= a[j++];
                // 뒷쪽 배열이 먼저 다 소진되면 앞에꺼 넣기
            else if (j > high) b[k]= a[i++];
                // 둘다 남아있을 때 비교
            else if(a[i]<a[j]) b[k]= a[i++];
            else b[k]= a[j++];

        }
        // 보조 배열 b를 배열 a에 복사
        for(int k=low; k<= high; k++) a[k]= b[k];

    }

    private static void sort(int[] a){
        int[] b= new int[a.length];
        sort(a,b,0, a.length-1);
    }
    private static void sort(int[]a, int[] b, int low, int high){
        if (high <= low) return;
        int mid= low+ (high- low)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1, high);
        merge(a,b,low, mid,high);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        sort(a);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }


    }
}