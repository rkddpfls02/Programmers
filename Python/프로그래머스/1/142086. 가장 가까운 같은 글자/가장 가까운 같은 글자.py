def solution(s):
    answer = []
    n = len(s)
    for i in range(n-1,-1,-1):
        if i ==0 :
            answer.append(-1)
        else:
            answer.append(findSame(i,s))
    
    return answer[::-1]

def findSame(i: int, s: str):
        cnt=0
        for j in range(i-1,-1,-1):
            cnt+=1
            if s[i]== s[j]:
                return cnt
        
        return -1

        
        
    
    