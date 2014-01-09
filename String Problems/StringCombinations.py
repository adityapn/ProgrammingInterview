combi = []

def combinations(array,string,position,length):
    if position == length:
        array[position] = 0
        combi.append(printCombinations(array,length,string))
        array[position] = 1
        combi.append(printCombinations(array,length,string))
        return
    array[position] = 0
    combinations(array,string,position+1,length)
    array[position] = 1
    combinations(array,string,position+1,length)


def printCombinations(array,length,string):
    sum = 0
    combinations = ""
    for i in range(0,length):
        if array[i] == 1:
            combinations += string[i]
            sum += 1

    if sum != 0:
        return combinations

string = "adity"
length = len(string)
array = [0 for i in range(0,length+1)]
combinations(array,string,0,length)
combi = list(set(combi))
print "Totally "+str(len(combi))
for c in combi:
    if c:
        print c
