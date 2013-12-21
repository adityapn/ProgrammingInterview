'''
Given a set of positive integers S = { a1,a2,a3,...,an} 
find two subsets s1 and s2 of A such that S2 = S - S1 and 
difference of | sum(S1) - sum(S2) | is minimum. 
For example if we have a set S={12,4,7,1,6,3,3 }
then S1= {12,6} and S2={ 4,7,1,3,3} such that sum(S1) - sum(S2) = 0 . 
It is not necessary that two subsets will always have the same sum.
'''

def balancePoint(li):
	left = li[0]
	right = 0
	minPoint = 0
	location = 0
	for i in li:
		right = right + i 
	minPoint = left - right	
	if minPoint <0:
		minPoint = -minPoint

	for i in range(0,len(li)-1):
		if left == right:
			print "Least value "+str(i)
			return
		else:
			temp = left-right
			if temp < 0:
				temp = -temp
			if temp < minPoint:
				minPoint = left-right
				if minPoint < 0 :
					minPoint = -minPoint
				location = i
		left = left + li[i+1]
		right = right - li[i]
	print str(minPoint)+" at "+str(location)


if __name__ == '__main__':
	li = [1,2,3,4,6,11]
	balancePoint(li)
