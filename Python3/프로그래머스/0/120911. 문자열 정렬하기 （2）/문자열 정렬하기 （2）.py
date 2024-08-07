def solution(my_string):
    my_string= my_string.lower()
    temp= list(my_string)
    temp.sort()
    return ''.join(temp)