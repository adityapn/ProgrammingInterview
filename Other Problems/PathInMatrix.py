'''
Example
1 2 3
4 5 6
7 8 9

path for root(0,0) 1
1-4-7
1-4-8
1-5-7
1-5-8
1-5-9

similarly path for 2(0,1)
2-4-7
2-4-8
2-5-7
2-5-8
2-5-9
2-6-8
2-6-9

note- root 1 can go to middle down or right down 
since there is no left index available. if root element 
has left middle and right it can go to all those paths like 2 or 5.

follow up : provide the path which has maximum path sum.
'''

def findPath(matrix,row,col,m,n):
	'''
	matrix = [[1,2,3],[4,5,6],[7,8,9]]	
	a , row = 0 ,0 
	b, col = 0 , 0
	'''
	path = dict()
	for i in range(0,m):
		col = col + 1
		row = row + 1
		path  = str(matrix[a][b])+"->"
		for j in range(0,col+1):
			if j > 2 or row > 2:
				break
			path  = path + str(matrix[row][j])+"->"
		print path	


def main():
	findPath()


if __name__ == '__main__':
	main()


		



