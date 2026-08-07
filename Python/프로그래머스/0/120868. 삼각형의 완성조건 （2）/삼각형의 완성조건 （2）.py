def solution(sides):
    i= 0 if sides[0]>sides[1] else 1
    c=sides[i]- sides[1-i]+1
    cnt=0
    while sides[i] < sides[1-i]+c and sides[i] >= c:
        cnt+=1
        c+=1
    
    c= sides[i]+1
    while c < sum(sides):
        cnt+=1
        c+=1
    return cnt