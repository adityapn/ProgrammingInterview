# Source : http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

def lps(string):
    length = len(string)
    # Table for sub problems
    matrix = [[1 for i in range(length)] for i in range(length)]    
    for cl in range(2,length+1):
        for i in range(0,length-cl+1):            
            j = i + cl - 1
            if string[i] == string[j] and cl == 2:
                matrix[i][j] = 2
            elif string[i] == string[j]:
                matrix[i][j] = matrix[i+1][j-1] + 2
            else:
                matrix[i][j] = max(matrix[i][j-1],matrix[i+1][j])
    
    return matrix[0][length-1]

print lps("Programming")
