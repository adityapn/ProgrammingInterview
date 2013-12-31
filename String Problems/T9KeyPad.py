

def permutate(string1,string2):
    temp = []
    for one in string1:
        for two in string2:
            concat = one+two
            temp.append(concat)

    return temp


def numbers(numbers_entered):
    length = len(numbers_entered)
    hashtable = dict()
    hashtable["1"] = "abc"
    hashtable["3"] = "ghi"
    hashtable["4"] = "jkl"
    
    if length > 2 :
        combinations = permutate(hashtable[str(numbers_entered[0])],hashtable[str(numbers_entered[1])])
        i = 2
        while i < length:            
            one = hashtable[str(numbers_entered[i])]
            combinations = permutate(combinations,one)
            i += 1
            
        return combinations
    elif length == 2:
        return permutate(hashtable[str(numbers_entered[0])],hashtable[str(numbers_entered[1])])
    else:
        return hashtable[str(numbers_entered[0])]
    

print numbers([1,3,4])
