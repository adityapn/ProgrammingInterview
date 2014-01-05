
# For explanation :
# http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

def find_path(matrix,final_point1,final_point2):

    if final_point1 < 0 or final_point2 < 0:
        print "points ("+str(final_point1)+","+str(final_point2)+")"
        return 1
    elif final_point1 == 0 and final_point2 == 0:
        return matrix[final_point1][final_point2]
    else:
        return matrix[final_point1][final_point2] + min(
                 find_path(matrix,final_point1-1,final_point2),
                 find_path(matrix,final_point1,final_point2-1),
                 find_path(matrix,final_point1-1,final_point2-1)
               )


matrix = [[1,2,3],[4,8,2],[1,5,3]]
print find_path(matrix,2,2)
