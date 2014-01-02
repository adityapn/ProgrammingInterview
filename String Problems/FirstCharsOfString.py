# A sentence is given which contains lowercase English letters and spaces.
# It may contain multiple spaces. Get first letter of every word and
# return the result as a string. The result should not contain any space.
# Complete the following method:

def firstLetter(string):
    temp = ""
    if string[0] != " ":
        temp += string[0]
    i = 0
    length = len(string)
    while i < length-1:
        if string[i] == " ":
            temp += string[i+1]
        i += 1
    print temp


string = "A sentence is given which contains lowercase English letters and spaces"    
firstLetter(string)
