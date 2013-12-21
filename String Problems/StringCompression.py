def compress(string):
	compressed = ""
	count = 0
	temp = string[0]
	
	for i in range(0,len(string)):
		if temp == string[i]:
			count = count + 1			
		else:
			compressed = compressed + str(temp) +str(count)
			count = 1
			temp = string[i]

		if i == len(string)-1:
			compressed = compressed + str(temp) +str(count)			

	return compressed

def decompress(string):
	for j in range(0,len(string)-1):
		if j%2 == 0:
			for i in range(0,int(string[j+1])):
				print string[j]

def main():
	string = "AAACCCBBDBB"
	print compress(string)
	decompress(compress(string))

if __name__ == '__main__':
	main()

