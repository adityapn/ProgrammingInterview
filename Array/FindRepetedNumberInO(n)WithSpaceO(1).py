import math

# Source : http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
# Assumtion is numbers are positive

def findRepeated(numbers):
    i = 0
    length = len(numbers)
    while i < length:
        if numbers[i] < length:
            if numbers[int(math.fabs(numbers[i]))] > 0:            
                numbers[int(math.fabs(numbers[i]))]  = - numbers[int(math.fabs(numbers[i]))]
            else:
                print "Duplicate "+str(int(math.fabs(numbers[i])))
        i = i + 1
    print numbers


numbers = [1, 2, 3, 3, 6, 6]
findRepeated(numbers)
