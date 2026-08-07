def solution(numbers):
    eng= ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    i=0
    for num in eng:
        if num in numbers:
            numbers= numbers.replace(num,str(i))
        i+=1
    return int(numbers)