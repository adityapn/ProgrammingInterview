import collections
'''
Problem :
Find the subsequences whose elements should not be adjacent and their sum should be maximum from the given array (contains only positive integers).
Eg: int[] A = {10, 1, 3, 25}
Sol: Sum: {10, 3} = 13
{1,25} = 26
{10,25} = 35
Here the Maximum subsequence is {10, 25}.

Approch :

compare the adj elements and find the max and keep them in the sum array
repeat until it's length is 2 (to form a pair)
'''
def findMaxNonAdj(array):
    sumList = []
    temp = array
    if len(array) < 2:
        print "Cannot form a pair"
        return
    while temp:
        for i in range(1,len(temp)):            
            sumList.append(max(temp[i-1],temp[i]))            
        temp = None
        temp = collections.OrderedDict.fromkeys(sumList).keys()#normal sets are unorderd
        print temp
        sumList = list()
        if len(temp) == 2:
            break

    print "Result "+str(temp)

def main():
    nums = [10,1,3,25]
    findMaxNonAdj(nums)

if __name__ == "__main__":main()
    
        
        
