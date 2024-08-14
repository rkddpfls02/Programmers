def solution(my_string):
    sum=0
    temp= ''
    for c in my_string:
        if c.isdigit():
            temp += c
        elif temp !='':
            sum += int(temp)
            temp= ''
    
    return sum+ (int(temp) if temp != '' else 0)