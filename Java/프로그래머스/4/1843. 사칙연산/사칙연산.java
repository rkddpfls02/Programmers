class Solution {
    public int solution(String arr[]) {
        int n= arr.length/2+1;
        int[] nums= new int [n];
        String[] operator= new String[n-1];
        
        int[][][] dp= new int [n][n][2]; // i부터 j 까지 계산한 값중 0번째에 최대 1번째에 최소값
        
        for(int i=0; i< arr.length; i++) {
            if(i%2==0) nums[i/2]= Integer.parseInt(arr[i]);
            else operator[i/2]= arr[i];

        }
        
        for(int i=0; i< n; i++){
            dp[i][i][0]= nums[i];
            dp[i][i][1]= nums[i];
        }
        
        // 작은거부터 먼저 해야함- 계산량이 작은거부터해야함
        for(int len= 1; len < n; len++){
            for(int i=0; i< n-len; i++){
                int j= i+len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k=i; k< j; k++){
                    // System.out.println(i+" "+j+" "+k);
                    if(operator[k].equals("-")){
                        // 최소는 기존 최소에서 최대를 뺄때
                        min= Math.min(dp[i][k][1]- dp[k+1][j][0], min);
                        
                        // 최대는 기존 최대에서 최소를 뺄때
                        max= Math.max(dp[i][k][0]- dp[k+1][j][1], max);
                        
                    } else{
                        // 최소는 기존 최소에서 최소를 더할때
                        min= Math.min(dp[i][k][1]+ dp[k+1][j][1], min);
                        
                        // 최대는 기존 최대에서 최대를 더할때
                        max= Math.max(dp[i][k][0]+ dp[k+1][j][0], max);
                        }
                    }
                    dp[i][j][0]= max;
                    dp[i][j][1]= min;
                
            }
        }
        
        return dp[0][n-1][0];
    }
}