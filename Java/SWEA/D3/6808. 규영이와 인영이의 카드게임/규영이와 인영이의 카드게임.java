
import java.util.*;
import java.io.*;

class Solution
{
	
	static int[] me;
	static int[] you;
	static boolean[] visited;
	static int win;
	static int lose;
	
	static void dfs(int depth, int meScore, int youScore) {
    	if(depth== 9) {
    		if(meScore> youScore) win ++;
    		else lose++;
    		return;
    	}
    	
    	for(int i=0; i< 9; i++) {
    		if(!visited[i]) {
    			visited[i]= true;
    			if(me[depth]> you[i]) dfs(depth+1, meScore+ me[depth]+you[i], youScore);
    			else dfs(depth+1, meScore , youScore+ me[depth]+you[i]);
    			visited[i]= false;
    		}
    	}
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
			win=0;
			lose=0;
			st = new StringTokenizer(br.readLine());
			
			me= new int [9];
			you= new int [9];
			int[] temp= new int [18];
			visited= new boolean[9];
			
			for (int i = 0; i < temp.length; i++) temp[i]= i+1;
			

			for(int i=0; i< 9; i++) {
				me[i]= Integer.parseInt(st.nextToken());
				temp[me[i]-1]=0;
			}
						
			you= Arrays.stream(temp).filter(item -> item != 0).toArray();
						
			dfs(0,0,0);
			
            bw.write("#"+test_case+" "+ win+" "+lose);
            bw.newLine();
            
		}
        
        bw.flush();
        bw.close();
        br.close();
	}
}