def pow(base,exp):
	result = 1

	while exp:
		if exp & 1:			
			result = result*base
			print result
		exp = exp >> 1		
		base = base*base	

	return result

def main():
	ans = pow(6,8)
	print ans

if __name__ == '__main__':
	main()
