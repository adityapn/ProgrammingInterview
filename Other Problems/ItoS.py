def convert(number):
	li = []
	li = range(1,number+1)
	s = str(li).replace("[",'"').replace("]",'"')

	return s

def main():
	st = convert(5)
	print st

if __name__ == '__main__':
	main()

