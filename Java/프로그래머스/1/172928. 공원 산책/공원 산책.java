class Solution {


    public int[] solution(String[] park, String[] routes) {
        
        int n= park.length;
        int m= park[0].length();
        
        // 갈수 있는곳은 0 아닌곳은 1로 표기
        int[][] map = new int[n][m];
        
        // 현재 위치
        int[] now= new int[2];
        
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                char c= park[i].charAt(j);
                map[i][j]= c=='X' ? 1:0;
                if(c=='S') now= new int[] {i,j};
            }
        }
        
        
        for(String str: routes){
            int[] tmp= {now[0],now[1]};

            String s= str.split(" ")[0];
            int move= Integer.parseInt(str.split(" ")[1]);
            boolean isValid= true;
            
            switch(s){

                case "E":
                    // 가는길 탐색
                    for(int i=1; i<= move;i++){
                       tmp[1] += 1;
                        if(tmp[1]<0 || tmp[1]>= m || map[tmp[0]][tmp[1]]==1) {
                            isValid= false;
                            break;
                        }
                    }
                    // 가는길 아무문제 없으면 now 갱신
                    if(isValid) now[1]= tmp[1];
                    break;
                        
                case "W":
                    
                    for(int i=1; i<= move;i++){
                       tmp[1] -= 1;
                        if(tmp[1]<0 || tmp[1]>= m || map[tmp[0]][tmp[1]]==1) {
                            isValid= false;
                            break;
                        }
                    }
                    // 가는길 아무문제 없으면 now 갱신
                    if(isValid) now[1]= tmp[1];
                    break;
                    
                case "S":
                    
                    for(int i=1; i<= move;i++){
                       tmp[0] += 1;
                        if(tmp[0]<0 || tmp[0]>= n || map[tmp[0]][tmp[1]]==1) {
                            isValid= false;
                            break;
                        }
                    }
                    
                    // 가는길 아무문제 없으면 now 갱신
                    if(isValid) now[0]= tmp[0];
                    break;
                    
                case "N":
                    
                    for(int i=1; i<= move;i++){
                       tmp[0] -= 1;
                        if(tmp[0]<0 || tmp[0]>= n || map[tmp[0]][tmp[1]]==1) {
                            isValid= false;
                            break;
                        }
                    }
                    
                    // 가는길 아무문제 없으면 now 갱신
                    if(isValid) now[0]= tmp[0];
                    break;
                    
            }
            
            System.out.println(now[0]+", "+ now[1]);

            
        }
        
        
        return now;
    }
   
    
}