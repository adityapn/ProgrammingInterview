import math

def findRepeated(numbers):
    i = 0
    length = len(numbers)
    while i < length:
        if numbers[int(math.fabs(numbers[i]))] > 0:            
            numbers[int(math.fabs(numbers[i]))]  = - numbers[int(math.fabs(numbers[i]))]
        else:
            print "Duplicate "+str(int(math.fabs(numbers[i])))
        i = i + 1 


numbers = [1, 2, 3, 1, 3, 6, 6]
findRepeated(numbers)
