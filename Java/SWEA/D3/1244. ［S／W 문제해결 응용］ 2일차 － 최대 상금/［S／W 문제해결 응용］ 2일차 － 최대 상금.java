import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	// 횟수, 숫자들
	static Map<Integer, Set<String>> setMap;
	
	public static void switchNum(int cnt, String path ) {
		
		if(cnt == n) {
			answer= Math.max(answer, Integer.parseInt(path));
			return;
		}
		
		for(int i=0; i< num.length(); i++) {
			for (int j = i+1; j < num.length(); j++) {
				
				if(i != j) {
					char[] c= path.toCharArray();
					char temp= c[i];
					c[i]= c[j];
					c[j]= temp;
 					String string= new String(c);
 					if(!setMap.get(cnt).contains(string)) {
 						setMap.get(cnt).add(string);
 						switchNum(cnt+1, string);
 						}
					
					}
			}
		}
	}
	

	
	static int answer;
	static String num;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			answer=0;
			
			String[] strings= br.readLine().split(" ");
			num= strings[0];
			n= Integer.parseInt(strings[1]);
			
			setMap= new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				setMap.put(i, new HashSet<>());
			}
			
			switchNum(0, num);
			
			bw.write("#"+test_case+" "+answer);
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
