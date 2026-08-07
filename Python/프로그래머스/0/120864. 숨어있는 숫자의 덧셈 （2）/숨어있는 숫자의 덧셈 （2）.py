def solution(my_string):
    sum=0
    temp= ''.join(c if c.isdigit() else ' ' for c in my_string)
    num= temp.split()
    for n in num:
        sum += int(n)
    return sum