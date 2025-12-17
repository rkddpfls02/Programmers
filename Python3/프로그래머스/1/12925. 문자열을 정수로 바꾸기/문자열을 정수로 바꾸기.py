def solution(s):
    
    isMinus= False
    if s[0]=='-':
        isMinus= True
        s= s[1:]
    elif s[0]=='+':
        s= s[1:]
        
    exp= len(s)-1
    answer=0
    for i in s:
        answer += int(i) * (10**exp)
        exp -=1
        
    answer= answer* (-1) if isMinus else answer
    
    return answer