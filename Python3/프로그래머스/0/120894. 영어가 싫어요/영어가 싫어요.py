def solution(numbers):
    eng= ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    answer=''
    while len(numbers) !=0:
        if numbers[0:3] in eng:
            answer+= str(eng.index(numbers[0:3]))
            numbers = numbers[3:]
        elif numbers[0:4] in eng:
            answer+= str(eng.index(numbers[0:4]))
            numbers = numbers[4:]
        else:
            answer+= str(eng.index(numbers[0:5]))
            numbers = numbers[5:]
    return int(answer)