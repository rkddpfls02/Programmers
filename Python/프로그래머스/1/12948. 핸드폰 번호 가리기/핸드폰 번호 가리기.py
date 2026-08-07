def solution(phone_number):
    numlen= len(phone_number)
    return '*'*(numlen-4)+ phone_number[numlen-4:]