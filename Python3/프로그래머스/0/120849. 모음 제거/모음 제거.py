def solution(my_string):
    vowels= ['a', 'e', 'i', 'o', 'u']
    answer=''
    for c in my_string:
        if not(c in vowels) :
            answer += c
    return answer