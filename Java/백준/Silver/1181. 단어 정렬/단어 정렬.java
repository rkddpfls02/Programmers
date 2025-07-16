import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder =  new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 단어 개수
        Set<String> set=  new HashSet<>(); //중복 제거
        ArrayList<String>[] arr =  new ArrayList[51]; // 단어 길이가 최대 50이라고해서 1~50

        for(int i=0; i<n; i++) set.add(br.readLine());
        for(int i=0; i< arr.length; i++) arr[i]= new ArrayList<>();

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String s= iterator.next();
            arr[s.length()].add(s);
        }

        for (ArrayList<String> list: arr){
            if(!list.isEmpty()){
                list.stream().sorted().forEach(s -> stringBuilder.append(s).append("\n"));
            }
        }

        bw.write(stringBuilder.toString());
        bw.close();
        br.close();



    }
}

