import java.util.*;
import java.io.*;

class Solution
{
	
	static int[] arr;
	static int k;
	static int n;
	static int answer;
	
	static void dfs(int idx, int sum) {
		if (idx == n) {
			if(sum == k) answer ++;
			return;
			}
		
		
		dfs(idx+1, sum+ arr[idx]);
		dfs(idx+1, sum);
    }
    
	
	public static void main(String args[]) throws Exception
	{
		
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		T= Integer.parseInt(br.readLine());

        StringTokenizer st;
        
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			st = new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			k= Integer.parseInt(st.nextToken());
			
			arr= new int [n];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i< n; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
									
			dfs(0,0);
			
            bw.write("#"+test_case+" "+answer);
            bw.newLine();
            
		}
        
        bw.flush();
        bw.close();
        br.close();
	}
}