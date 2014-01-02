# Divied an array in two equal halfs such that left half minus right half
# Gives minimum difference 

import math

def partition(array):
	length = len(array)
	if length > 2:
		leftSum = array[0]
		rightSum = array[1]
		count = 2
		left = [array[0]]
		right = [array[1]]
		while count < length-1:
			if leftSum < rightSum:
				if array[count] < array[count+1]:
					rightSum += array[count]
					right.append(array[count])
					leftSum += array[count+1]
					left.append(array[count+1])
					count += 2
				else:
					rightSum += array[count+1]
					right.append(array[count+1])
					leftSum += array[count]
					left.append(array[count])
					count += 2
			elif leftSum > rightSum:
				if array[count] < array[count+1]:
					leftSum += array[count]
					left.append(array[count])
					rightSum += array[count+1]
					right.append(array[count+1])
					count += 2
				else:
					leftSum += array[count+1]
					left.append(array[count+1])
					rightSum += array[count]
					right.append(array[count])
					count += 2
			else:
				leftSum += array[count]
				left.append(array[count])
				rightSum += array[count+1]
				right.append(array[count+1])
				count += 2



		print "difference is "+str(math.fabs(leftSum-rightSum))		
		print "Left "+str(left)+" Right "+str(right)

array = [1,2,3,4,5,6,7,8,9,10,11,12]
partition(array)
