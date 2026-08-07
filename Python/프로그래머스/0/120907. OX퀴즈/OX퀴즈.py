def solution(quiz):
    answer= []
    for c in quiz:
        f= c.split(" ")
        a= int(f[0])
        b= int(f[2])
        if f[1] == '+':
            result= a+b
        else:
            result= a-b
        answer.append('O' if result== int(f[4]) else 'X')
    return answer
        