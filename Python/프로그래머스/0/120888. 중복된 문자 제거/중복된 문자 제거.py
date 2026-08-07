# 중복 제거는 set 생각하기
def solution(my_string):
    answer=''
    str=set(my_string)
    for s in my_string:
        if s in str:
            answer += s
            str.remove(s)
    return answer