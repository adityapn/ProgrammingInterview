# We have to consider the -ve elements also
# Consider you have n number initialze first sum = first element
# Iterate through the list and add the new element only if it can 
# increase the sum

# For explanation : http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
li = [-2, -3, 4, -1, -2, 1, 5, -3]

def maxSubSequence(li):
    if li is not None:
        max_sum = 0
        for i in range(0,len(li)):
            temp = li[i] + max_sum            
            if li[i] > 0:
                max_sum += li[i]
            elif temp > 0:
                max_sum += li[i]
            
        print max_sum


maxSubSequence(li)
