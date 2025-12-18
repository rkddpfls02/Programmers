def solution(arr):
    answer= []
    
    for i in range(0,len(arr)):
        if(len(answer) !=0 and answer[-1] == arr[i]):
            answer.pop()
        answer.append(arr[i])
        
    return answer