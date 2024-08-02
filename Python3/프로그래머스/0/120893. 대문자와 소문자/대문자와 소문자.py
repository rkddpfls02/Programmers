#아스키코드 변환 함수 ord
def solution(my_string):
    answer= ''
    for c  in my_string:
        #소문자인거임
        if ord(c) > ord('Z'):
            answer+= chr(ord('A')+(ord(c)-ord('a')))
        else:
            answer += chr(ord('a')+(ord(c)-ord('A')))
    return answer