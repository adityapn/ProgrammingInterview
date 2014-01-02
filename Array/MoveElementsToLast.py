# Given an array of size N, move the first d elements to its last.
# e.g. {1, 2, 3, 4, 5}, d=2 output: {3, 4, 5, 1, 2}

def moveLast(array,n):
    i = 0
    while i < n:
        array.append(array[0])
        del array[0]
        i = i + 1    
    print array

array = [1, 2, 3, 4, 5]
moveLast(array,2)
