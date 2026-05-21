import java.util.*;
import java.io.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int n= 100;
        int T= 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int t= Integer.parseInt(br.readLine());
            int [][] arr= new int [n][n];
            int[] horizontal= new int [n];
            int[] vertical= new int [n];
            int diagonal1=0; // 우하향
            int diagonal2=0; // 좌하향
            
             for(int i=0; i< n; i++) {
                 String[] s= br.readLine().split(" ");
            	 for(int j=0; j< n; j++) {
                     int num= Integer.parseInt(s[j]);
            		 horizontal[i] += num;
                     vertical[j] += num;
                     if(i == j) diagonal1+= num;
                     if(n == j+i+1) diagonal2+= num;
            	 }
            }
            
            int answer= Math.max(diagonal1,diagonal2);
            Arrays.sort(horizontal);
            Arrays.sort(vertical);
            answer= Math.max(answer, horizontal[n-1] );
            answer= Math.max(answer, vertical[n-1] );
            
            bw.write("#"+t+" "+answer+"\n");
		}
        
        bw.flush();
        br.close();
        bw.close();
        	
	}
}