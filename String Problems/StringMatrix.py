# -*- coding: cp1252 -*-
'''
Amazon Interview :

Given a String s and int r , first fill each character row wise and print column wise.
for e.g. String s = “abcdefgh” and r = 3
so filling column wise would give :
a d g
b e h
c f

'''
import math

def makeStringMatrix(strings,rows):
    length = len(strings)    
    cols = 0
    mod = length%rows
    if mod > 0:
        cols = mod + 1
    else:
        cols = length/rows
    
    matrix = [[0 for i in range(cols)]for i in range(0,rows)]
    start = 0
    i = 0
    for row in range(0,rows):
        start = row
        for col in range(0,cols):
            try:
                matrix[row][col] = strings[start]                
            except Exception:
                pass                
            start = start + rows 
    
    for row in range(0,rows):
        temp = ""
        for col in range(0,cols):
            if type(matrix[row][col]) is not int:
                temp = temp +" "+matrix[row][col]
        print temp
    
    
makeStringMatrix("abcdefgh",2)
