def DiagnolElements(matrix):
    li = dict()
    for i in range(0,len(matrix)):
        li[matrix[i][i]] = i

    return li

def crossMatrix(matrix):
    diagnol = DiagnolElements(matrix)
    for i in range(0,len(matrix)):
        for j in range(0,len(matrix)):
            if i != j:
                if diagnol.get(matrix[i][j]):
                    return False
    return True

def main():
    matrix = [[1,2,3],[4,5,6],[7,8,9]]
    if crossMatrix(matrix):
        print("Cross Matrix")
    else:
        print("Not a cross matrix")
    

if __name__ == "__main__":main()
            
