# http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

def max_subarray_sum(elements):
    temp_sum = 0
    final_sum = elements[0]
    for element in elements:        
        temp_sum += element
        if temp_sum > final_sum:
            final_sum = temp_sum            
        if temp_sum < 0:
            temp_sum = 0        
    
    return final_sum


print max_subarray_sum([-2, -3, 4, -1, -2, 1, 5, -3])
