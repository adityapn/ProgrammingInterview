def subSum(lis,ite):
	for i in range(1,ite+1):
		for j in range(0,len(lis)-1):			
			lis[j] = lis[j+1] - lis[j]
	for temp in range(1,ite+1):
		lis.pop()
	sum = 0
	for item in lis:
		sum = sum + item

	return sum

def main():
	li = [5,3,8,9,16]
	print subSum(li,2)

if __name__ == '__main__':
	main()