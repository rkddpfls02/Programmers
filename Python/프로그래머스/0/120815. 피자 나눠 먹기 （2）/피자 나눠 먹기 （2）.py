def solution(n):
    k =1
    while True :
        if (n * k) % 6 ==0:
            return (n*k)//6
        k +=1