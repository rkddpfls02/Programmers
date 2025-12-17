def solution(absolutes, signs):
    
    result=0
    
    for num, sign in zip(absolutes, signs) :
        result += num if sign else -1* num
    
    return result 