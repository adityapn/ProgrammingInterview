#You are given an unsorted array with both positive and negative elements.
#You have to find the smallest positive number missing from the array in O(n)
#time using constant extra space. You can modify the original array.
# Examples Input: {2, 3, 7, 6, 8, -1, -10, 15} Output: 1

import math

def findMissingPostives(array):
    length = len(array)
    for i in range(0,length):
        absval = int(math.fabs(array[i])) 
        if absval - 1 < length and absval - 1 > 0:            
            array[absval - 1] = -array[absval - 1]

    print array
    for i in range(0,length):
        if array[i] > 0:
            print "Missing number is "+str(i+1)
            
           
li = [1,7,9,3]
findMissingPostives(li)
