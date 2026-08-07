def solution(arr, divisor):
    arr.sort()
    arr = [num for num in arr if num % divisor ==0]
    return [-1] if len(arr)==0 else arr