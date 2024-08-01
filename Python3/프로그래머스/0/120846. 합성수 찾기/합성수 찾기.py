def solution(n):
    cnt=0
    for i in range(n,0,-1):
        for k in range(i-1,1,-1):
            if i%k==0:
                cnt+=1
                break
    return cnt