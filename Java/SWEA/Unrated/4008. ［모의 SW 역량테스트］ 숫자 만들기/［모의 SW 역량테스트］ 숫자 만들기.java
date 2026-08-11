import java.io.*;
import java.util.*;


public class Solution {
	
	
	private static int[] nums;
	private static int min;
	private static int max;
	private static int[] opertators; // 연산자 개수
	
	private static void cal(int cnt, int[] now) {
		if(cnt == nums.length-1 ) {
			operation(now);
			return;
		}
		
		for (int i = 0; i < opertators.length; i++) {
			if(opertators[i]> 0) { // i번째 연산자 남아있으면 선택하고 하나씩 없앰
				now[cnt]= i;
				opertators[i]--;
				cal(cnt+1, now);
				opertators[i]++; // 다시 추가해줘야지 다른 경우에서 씀
				}
		}
	}
	
	
	
	
	private static void operation(int[] now) {
		
		// 순서대로 계산하고 now의 인덱스에 따라 연산자 선택함 
		int sum= nums[0];
		for (int i = 0; i < now.length; i++) {
			switch (now[i]) {
			case 0: {
				sum += nums[i+1];
				break;
			}
			
			case 1: {
				sum -= nums[i+1];
				break;
			}
			
			case 2: {
				sum *= nums[i+1];
				break;
			}
			
			default: {
				sum /= nums[i+1];
				break;
			}
				
			}
		}
		min= Math.min(min, sum);
		max= Math.max(max, sum);
		
	}




	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			min= Integer.MAX_VALUE;
			max= Integer.MIN_VALUE;
			StringTokenizer stringTokenizer;
			
			int n= Integer.parseInt(br.readLine());
			
			nums= new int[n];
			opertators= new int[4];
			
			stringTokenizer= new StringTokenizer(br.readLine());
			for(int i=0; i< 4; i++) opertators[i]= Integer.parseInt(stringTokenizer.nextToken());
			
			
			stringTokenizer= new StringTokenizer(br.readLine());
			for(int i=0; i< n; i++) nums[i]= Integer.parseInt(stringTokenizer.nextToken());
			
			
			cal(0, new int[n-1]);

			bw.append("#"+test_case+" "+(max-min));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
