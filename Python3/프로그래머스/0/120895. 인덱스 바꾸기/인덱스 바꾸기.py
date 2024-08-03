def solution(my_string, num1, num2):
    sarr= list(my_string)
    temp= sarr[num1]
    sarr[num1]= sarr[num2]
    sarr[num2]= temp
    #요소들을 하나의 문자열로 합칠 때는 join() 메서드
    return ''.join(sarr)