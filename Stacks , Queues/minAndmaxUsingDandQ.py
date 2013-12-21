import math
#Using divide and conquor

def divide(array,start,end,min1,max1):
	if start == end: # Array with one element
		min1 = max1 = array[start]
	elif (math.fabs(start-end) == 1):
		# When there are only two elements 
		li = []
		if array[start] < array[end]:
			min1 = array[start]
			max1 = array[end]			
		else:
			min1 = array[end]
			max1 = array[start]
		li.append(min1)
		li.append(max1)
		return li		
	else:
		# When there are more than 2 elements
		mid = (start+end)/2
		left = divide(array,start,mid,min1,max1)
		right = divide(array,mid+1,end,min1,max1)
		if left is not None:
			if min1 > left[0]:
				min1 = left[0]
			if max1 < left[1]:
				max1 = left[1]
			print "Left min "+str(min1)+" max "+str(max1)
		if right is not None:
			if min1 > right[0]:
				min1 = right[0]
			if max1 < right[1]:
				max1 = right[1]
	

# Without divide and conquor 
def minAndmax(li):
	maxE = minE = li[0]
	length = len(li)
	for i in range(1,length):
		if minE > li[i]:
			minE = li[i]
		elif maxE < li[i]:
			maxE = li[i]
	print "Min "+str(minE)+" Max "+str(maxE)

elements = [1,234,23,641,767,12]

divide(elements,0,len(elements)-1,elements[0],elements[0])