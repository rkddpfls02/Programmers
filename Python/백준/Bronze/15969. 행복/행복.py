n= input()
strlist= input().split(' ')
numlist= list(map(int, strlist))
print(max(numlist)-min(numlist))