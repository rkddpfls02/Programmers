def solution(my_string):
    cal= my_string.split(' ')
    sum= 0
    plus= True
    for c in cal:
        if c.isdigit() and plus:
            sum += int(c)
        elif c.isdigit():
            sum -= int(c)
        elif c == '+':
            plus = True
        else:
            plus= False
    return sum
