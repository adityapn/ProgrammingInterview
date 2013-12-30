
def binary_search(li , start , end , item):    
    if start > end:
        return None
    middle = (start + end)/2
    
    if li[middle] == item:        
        return middle
    elif li[middle] < item:
        result  = binary_search(li,middle+1,end,item)
    else:
        result =  binary_search(li,start,middle-1,item)
    return result
        

def countDistintPairs(sum_to_form,numbers):
    # Remove the duplicates in the list 
    numbers = list(set(numbers))
    length = len(numbers) - 1 
    # Sort the list 
    numbers.sort()
    count = 0
    for number in numbers:
        temp_sum = sum_to_form + number
        pos = binary_search(numbers,0,length,temp_sum)
        if pos is not None:
            count = count + 1
            
    print count

countDistintPairs(4,[8, 12, 16, 4, 0, 20])

