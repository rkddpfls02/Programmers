def solution(array):
    numset= set(array)
    num= list(numset)
    count=[0]* len(num)
    for n in array:
        for i in range(0, len(num)):
            if(n == num[i]):
                count[i] +=1
    maxcnt=0
    for m in count:
        if m == max(count):
            maxcnt +=1
    if maxcnt >1 :
        return -1
    else:
        return num[count.index(max(count))]
