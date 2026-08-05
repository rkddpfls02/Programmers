import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {
	
	static void makeFood(int idx, int cnt, int[] foods) {
		if (idx== n) return;
		if (cnt== n/2) {
			calflavor(foods);
			return;
			}
			
		makeFood(idx+1, cnt, foods);
		
		int[] tmp;
		tmp= Arrays.copyOf(foods, cnt+1);
		tmp[cnt]= idx;
		
		makeFood(idx+1, cnt+1 , tmp);
	}
	
	
	static void calflavor(int[] foods) {
		
		int[] nums= new int[n];
		for(int i=0;i< n; i++) nums[i]= i;
		for(int i=0; i< n/2; i++) nums[foods[i]]=-1;
		int[] tmp= Arrays.stream(nums).filter(num -> num!=-1).toArray();
		
		int total=0;
		int total2=0;
		
		for(int i=foods.length-1; i>=0; i--) {
			
			for(int j=i-1; j>=0; j--) {
				
			total += ingredients[foods[i]][foods[j]]+ ingredients[foods[j]][foods[i]];
			total2 += ingredients[tmp[i]][tmp[j]]+ ingredients[tmp[j]][tmp[i]];
			
			}
			
		}
		
		answer= Math.min(answer, Math.abs(total-total2));
		
	}
	
	
	static int[][] ingredients;
	static int n;
	static int k;
	static int answer;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			answer= Integer.MAX_VALUE;
			
			n= Integer.parseInt(br.readLine());
			
			ingredients= new int[n][n];
		
			for(int i=0; i< n; i++) {
				StringTokenizer stringTokenizer= new StringTokenizer(br.readLine());
				for(int j=0; j< n; j++) ingredients[i][j]= Integer.parseInt(stringTokenizer.nextToken());
			}
			
			makeFood(0, 0, new int[] {});

		
			bw.write("#"+test_case+" "+answer);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
