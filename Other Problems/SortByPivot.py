'''
Suppose there is an array with numbers :

1, 14, 5, k, 4, 2, 54, k, 87, 98, 3, 1, 32

Output for this can be assuming k =20

1,14,5,4,2,3,1,k,k,54,87,98,32

Now sort this array in a way all k are in middle and all values on 
left of k are smaller (in any order) and on right are larger(in any order)
'''
'''
My Answer : Create two stacks for min and max and at the end merge them 
'''

def sortOverPivot():
	minStack = []
	maxStack = []
	li = [1,5,2,34,73,36,83]
	pivotVal = 34
	for val in li:
		if val > pivotVal:
			maxStack.append(val)
		elif val < pivotVal:
			minStack.append(val)
		else:
			pass
	li = None
	li = []
	while True:
		for v in minStack:
			li.append(v)
		li.append(pivotVal)
		for m in maxStack:
			li.append(m)
		break

	print li


def main():	
	sortOverPivot()

if __name__ == '__main__':
	main()

