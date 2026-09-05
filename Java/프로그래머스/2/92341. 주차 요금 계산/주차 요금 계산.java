import java.util.*;
class Solution {
    public static class Car{
        int timeSum=0;
        boolean in= false;
        int inH=0;
        int inM=0;
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        // 차번호, 차 요금 Map
        Map<String, Car> result= new HashMap<>();
        
        // 차번호 오름차순 하기 위한 임시 배열
        List<int[]> tmp= new ArrayList<>();
        
        Car car;
        for(String record: records){
            String[] s= record.split(" ");
            
            // 들어올때
            if(s[2].equals("IN")) {
                if(result.containsKey(s[1])){
                    car= result.get(s[1]);                    
                } else {
                    car= new Car();
                }
                
                car.in= true;
                car.inH= Integer.parseInt(s[0].split(":")[0]);
                car.inM= Integer.parseInt(s[0].split(":")[1]);
                result.put(s[1], car);
            }
            else{
                // 나갈때
                car= result.get(s[1]);  
                int outH= Integer.parseInt(s[0].split(":")[0]);
                int outM= Integer.parseInt(s[0].split(":")[1]);
                // 시간 계산
                car.timeSum+= (outH-car.inH)*60+ outM-car.inM;
                car.in= false;
            }
            
        }
        
        // 주차요금 계산
        for(String key : result.keySet()){
            // 무조건 기본요금은 부과
            int sum= fees[1];
            car= result.get(key);
            
            // 출차 안했으면 23:59 기준으로 출차
            if(car.in){
                car.timeSum+= (23-car.inH)*60+ 59-car.inM;
            }
                
            // 기준시간 넘은 경우만 추가요금
            if(car.timeSum > fees[0]){
                int cnt= (car.timeSum- fees[0])%fees[2] !=0? (car.timeSum- fees[0])/fees[2]+1: (car.timeSum- fees[0])/fees[2];
                sum+= cnt* fees[3];
            }
                
            // 차번호와 총요금 저장
            tmp.add(new int[] {Integer.parseInt(key), sum});
            }
        
        // 차번호 기준 정렬
        Collections.sort(tmp, (c1,c2)-> c1[0]-c2[0]);
        
        int[] answer= new int [tmp.size()];
        for(int i=0; i< tmp.size(); i++){
            answer[i]= tmp.get(i)[1];
        }
        return answer;
    }
}