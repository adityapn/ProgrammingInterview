def matrix_diagnol(matrix,row,col):
	count = 0
	lines = row + col 
	while count < row:
		temp = count 
		result = ""		
		for i in range(0,count+1):
			result  = result +str(matrix[temp][i])+" "
			temp = temp - 1
		print result
		count = count + 1
	
	count = 1	
	Column = 1
	while count < col+1:		
		result = ""		
		start = row - 1
		diff = start - count + 1
		#print "Diff "+str(diff)+" count "+str(count)
		temp = Column
		for j in range(1,diff+1):
			result = result+ str(matrix[start][temp])+" "
			start = start-1
			temp = temp + 1
		Column = Column + 1
		print result
		
		count = count + 1


def main():
	matrix = [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
	matrix_diagnol(matrix,5,5)

if __name__ == '__main__':
	main()


