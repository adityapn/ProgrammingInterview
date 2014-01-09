import math

# Dynamic programming way Complexity O(nm) 
def dp_lcs(str1,str2,len1,len2):
    if str1 is None or str2 is None:
        return 0
    if len1 == 0 and len2 == 0:
        return 0
    if str1 == str2:
        return len1
    
    matrix = [[0 for i in range(0,len2+1)] for j in range(0,len1+1)]
    for i in range(1,len1+1):
        for j in range(1,len2+1):
            if str1[i-1] == str2[j-1]:                
                matrix[i][j] = matrix[i-1][j-1] + 1
            else:
                matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1])


    
    return matrix[len1][len2]

string1 = "ABAZDC"
string2 = "BACBAD"
print dp_lcs(string2,string1,len(string2),len(string1))
