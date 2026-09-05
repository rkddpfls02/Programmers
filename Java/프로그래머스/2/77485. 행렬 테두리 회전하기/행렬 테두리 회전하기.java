class Solution {
    
    public static int[][] nums;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        nums= new int [rows+1][columns+1];
        int[] answer= new int[queries.length];
        
        int [] dx= {0, 1, 0, -1};
        int [] dy= {1, 0, -1, 0};
        
        int num= 1;
        for(int i=1; i<= rows; i++){
            for(int j=1; j<= columns; j++){
                nums[i][j]= num++;
            }
        }
        
        for(int i=0; i< queries.length; i++){
            // 현재 회전 2개 좌표
            int[] query= queries[i];
            int x1= query[0], y1= query[1], x2= query[2], y2= query[3];
            
            // 현재 회전 배열 최솟값
            int min= nums[x1][y1];
            
            // 마지막 원소를 시작점에 옮기고 시작
            nums[x1][y1]= nums[x1+1][y1];
            
            // 다음 원소는 현재 원소
            int next= min;
            
            int x= x1, y= y1+1;
                        
            int idx= 0;
            
            while(x != x1-1 || y != y1){
                // 숫자 회전코드- 이전걸 지금 배열에, 지금 배열꺼 다음꺼에
                int tmp= nums[x][y];
                nums[x][y]= next;
                next= tmp;
                
                min= Math.min(min, nums[x][y]);
                if((x==x1 && y== y2)||(x==x2 && y==y2)||(x==x2 && y==y1)) idx ++;
                int nx= x+ dx[idx%4];
                int ny= y+ dy[idx%4];
                x= nx;
                y= ny;
                
            }
            answer[i]= min;
        }
        
        return answer;
    }
}