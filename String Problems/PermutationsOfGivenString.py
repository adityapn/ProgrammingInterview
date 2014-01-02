
string = ['a','b','c']

def swap(char1,char2):
    global string
    temp = string[char1]
    string[char1] = string[char2]
    string[char2] = temp
    
def permutations(start,end):
    global string
    if start == end:
        temp = ""
        for s in string:
            temp += s
        print temp
    else:
        for j in range(start,end):
            swap(start,j)
            permutations(start+1,end)
            swap(start,j)


permutations(0,3)
