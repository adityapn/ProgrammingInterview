import math

def findPresionValue(number):
	precision = number - math.floor(number)
	for i in range(1,30):
		temp = precision*i
		if temp == math.floor(temp):
			return temp
	    			
def toBinary(number):
	extra = number - math.floor(number)
	if extra == 0:
		print str(bin(number))+".0"
	else:
		temp = findPresionValue(number)
		print str(bin(int(math.floor(number))))+"."+str(bin(int(temp)))

def main():
	toBinary(7.25)

if __name__ == '__main__':
	main()


		
