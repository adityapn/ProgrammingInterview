
# Print all matrix elements in diagonal fashion

def Matrix_diagonally(matrix,rows,cols):
    count = 0
    lines = rows + cols
    start = 0
    
    while count < rows:
        result = ""
        temp = count
        
        for i in range(start,count+1):
            result = result + " "+str(matrix[i][temp])+" "
            temp = temp - 1
        print result
        if count == rows -1:
            start += 1
        count = count + 1

    # Print other half    
    count = 1
    while count < rows:
        result = ""
        temp = count
        end = rows - 1
        diff = end - count + 1
        for i in range(start,diff+1):
            result = result + " "+str(matrix[i][temp])+" "
            temp = temp - 1
        print result
        count = count + 1

matrix = [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
Matrix_diagonally(matrix,len(matrix[0]),len(matrix))
            
