
# Question source (Amazon Interview)
# http://www.geeksforgeeks.org/amazon-interview-set-55-on-campus/
# Given a matrix(not necessarily square) in which the elements in a row,
# as well in a column are sorted. Find a given integer in the matrix.

matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]

def binary_search(li , start , end , item):    
    if start > end:
        return None
    middle = (start + end)/2    
    if li[middle] == item:        
        return middle
    elif li[middle] < item:
        result  = binary_search(li,middle+1,end,item)
    else:
        result =  binary_search(li,start,middle-1,item)
    return result


def findElement(matrix,element):
    rows = len(matrix)
    cols = len(matrix[0])
    for row in range(0,rows):
        column_at = binary_search(matrix[row],0,cols-1,element)        
        if column_at:
            print "Element found at row "+str(row)+" column "+str(column_at)
            break        
                                     

findElement(matrix,3)
