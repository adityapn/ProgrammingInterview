
# Given an array of integers, {1,0,2,0,3,0,0,4,5,6,7,0,0,0},
# you have to create a new array which will be like (1,2,3,4,5,6,7,0,0,0,0,0,0,0},
# without using any other temporary array.

def makeArray(numbers):
    no_of_zeros = 0
    temp_pos = 0
    for number in numbers:
        if number == 0:
            no_of_zeros += 1
        else:
            new_list.a
