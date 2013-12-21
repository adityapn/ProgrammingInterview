'''
Given an array of numbers, arrange them in a way that yields the largest value. 
For example, if the given numbers are {54, 546, 548, 60}, 
the arrangement 6054854654 gives the largest value. 
And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
then the arrangement 998764543431 gives the largest value.
'''

def findBigNumber(li):
	one = ""
	two = ""
	temp = None
	len1 = None
	len2 = None
	for i in range(0,len(li)-1):
		one = str(li[i])
		two = str(li[i+1])
		if int(one[0]) > int(two[0]):
			temp = li[i]
			li[i] = li[i+1]
			li[i+1] = temp
		elif int(one[0]) == int(two[0]):
			small= None
			length = None
			length = len(str(li[i])-len(str(li[i+1])											
			len1 = len(str(li[i]))
			len2 = len(str(li[i+1]))
			if len1 > len2:
				small = len(str(li[i+1]))-1
				if int(str(li[i])) < int(str(li[small+length])):			
					temp = li[i]
					li[i] = li[i+1]
					li[i+1] = temp		

			if length < 0:
				length = -length

	return li

def main():
	change = [54, 546, 548, 60]
	change = findBigNumber(change)

if __name__ == '__main__':
	main()








