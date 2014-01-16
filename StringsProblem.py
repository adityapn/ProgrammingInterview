
# Problem : A set of chars are given like a , b , b , c, a ,c , a , c , b
# We have to make them like a , a , a , b , b , b , c , c , c

# assume this as character array in C/C++ 
strings = ['a' , 'b' , 'b' , 'c' , 'a' , 'c' , 'a' , 'c' , 'b']

# Directly sort strings , if we quick or merge then it take O(nlong) time complexity
def sortingWay(strings):
    return sorted(strings)

# Another approch :
# find out all unique elements and find out how many times they are repeted
# and store element to times repeted in hash table

hashtable = dict()

# this function helps to form the hashtable
def makeHashtable(strings):
    global hashtable
    for string in strings:
        # check if the value is already present in hash table
        if hashtable.get(string):
            # increment the value by 1
            hashtable[string] += 1
        else:
            hashtable[string] = 1    


# Club the chars based on their value
def putCharTogeathers(strings):
    global hashtable
    # if it an empty string then return false
    if len(strings) < 2 and strings is None:
        return False
    # Get the unique charecter from hash table
    makeHashtable(strings)
    unique_chars = sorted(hashtable.keys())
    i = 0
    j = 1
    length = len(strings)
    while i < length:
        # if this is the minimum character 
        if strings[i] == unique_chars[0]:
            i += 1
            j += 1
        else:
            if strings[i] 
    
putCharTogeathers(strings)
