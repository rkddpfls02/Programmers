import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> treeFrequency = new HashMap<>();

        // 총 나무 수 라인 하나씩 읽을 때마다 더해주기
        int cnt=0;

        String line;
        while ((line= br.readLine()) != null  && !line.isEmpty()){
            cnt++;
            if (treeFrequency.containsKey(line)) treeFrequency.put(line, treeFrequency.get(line)+1);
            else treeFrequency.put(line,1);
        }

        List<String> trees = new ArrayList<>(treeFrequency.keySet());
        Collections.sort(trees);

        Iterator<String> it= trees.iterator();
        String tree;

        while (it.hasNext()){
            tree= it.next();
            // 넷째자리에서 반올림
            System.out.printf("%s %.4f%n", tree, treeFrequency.get(tree)/ (double)cnt*100);
        }


    }

}
