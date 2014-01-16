

numbers = [1,2,3,4,5,6,7,8,9,10,12,13]

def findTriplets(numbers):
    powers_of_numbers = find_powers(numbers)
    i = 0
    length = len(powers_of_numbers)
    while i < length:
        pair = find_pairs(powers_of_numbers,powers_of_numbers[i],i)
        if pair:
            print "pair ("+str(powers_of_numbers[i])+","+str(pair[0])+","+str(pair[1])+")"
        i += 1

def find_pairs(array,sum_to_find,max_len):
    i = 0
    j = max_len
    indexs = []
    while i < j:
        temp = array[i] + array[j]
        if temp == sum_to_find:
            indexs.append(array[i])
            indexs.append(array[j])
            break
        if temp < sum_to_find:
            i += 1
        if temp > sum_to_find:
            j -= 1
    
    return indexs

def find_powers(numbers):
    result = []
    for number in numbers:
        temp = number*number
        result.append(temp)

    return result
    

findTriplets(numbers)
