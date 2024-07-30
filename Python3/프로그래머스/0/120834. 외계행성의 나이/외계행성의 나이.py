# ord는 chr을 아스키코드로 바꿔줌
def solution(age):
    answer=''
    for c in str(age):
        answer+= chr(ord('a')+int(c))
    return answer