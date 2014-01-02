# Given an array. Iterate it for the given number of times.
# And then return the summation of the resultant elements.
# Ex: Array is { 1,2,5,6}, N=2
# After 1st iteration: {2-1, 5-2, 6-5}={1,3,1}
# After 2nd : {3-1, 1-3}={2,-2}
# Sum is 2  + (-2) = 0

def arraysum(array,n):
    length = len(array)
    count = 0    
    while count < n:
        i = 0
        while i < length-1:
            temp = array[i]
            array[i] = array[i+1] - array[i]
            i += 1
        del array[length-1]
        length = len(array)
        count += 1
    sum = 0
    for num in array:
        sum += num

    print sum


        
arraysum([1,2,5,6],2)
