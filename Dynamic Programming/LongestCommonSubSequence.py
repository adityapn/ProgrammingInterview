import math


def dp_lcs(str1,str2,len1,len2):
    matrix = [[0 for i in range(0,len1+1)] for j in range(0,len2+1)]
    old = []
    temp = ""
    for i in range(0,len1):
        for j in range(0,len2):
            if str1[i-1] == str2[j-1]:
                temp += str1[i-1]
                matrix[i][j] = matrix[i-1][j-1] + 1
            else:
                matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1])
    print old
    return matrix[len1-1][len2-1]

# Using naive method with recurssion 
old = None
def lcs(string1,string2,len1,len2,temp=""):
    if len1 == 0 or len2 == 0:
        global old
        if old is not None:
            if len(old) > temp:
                old = temp
        else:
            old = temp
        return 0
    if string1[len1-1] == string2[len2-1]:
        temp += string1[len1-1]
        return 1+lcs(string1,string2,len1-1,len2-1,temp)
    else:
        return max(lcs(string1,string2,len1,len2-1,temp),lcs(string1,string2,len1-1,len2,temp))

string1 = "AGGTAB"
string2 = "GXTXAYB"
print dp_lcs(string1,string2,len(string1),len(string2))

