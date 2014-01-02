import math

def dp_lcs(str1,str2,len1,len2):
    matrix = [[0 for i in range(0,len1+1)] for j in range(0,len2+1)]
    for i in range(0,len1):
        for j in range(0,len2):
            if str1[i-1] == str2[j-1]:
                matrix[i][j] = matrix[i-1][j-1] + 1
            else:
                matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1])
    return matrix[len1-1][len2-1]


string1 = "AGGTAB"
string2 = "GXTXAYB"
print dp_lcs(string1,string2,len(string1),len(string2))

