def solution(s):
    sum=0
    slist= s.split(' ')
    for i in range(len(slist)):
        if slist[i] == 'Z':
            sum -= int(slist[i-1])
        else:
            sum += int(slist[i])
    return sum