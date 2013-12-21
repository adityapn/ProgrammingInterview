# We have to consider the -ve elements also
# Consider you have n number initialze first sum = first element
# Iterate through the list and add the new element only if it can 
# increase the sum

li = [-2,-3,4,-1,5,-3]

def maxSubSequence(li):
    if li is not None:
        subSum = li[0]
        for i in range(1,len(li)):
            temp = li[i] + subSum
            if temp > subSum:
                subSum = temp
        print subSum


maxSubSequence(li)
