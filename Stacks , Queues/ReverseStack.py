
def reverse(s):
	if s is None:
		return

	data = 0 
	try:
		data = s.pop()
	except Exception:
		return
		
	reverse(s)
	s.append(data)

def main():
	stack = [1,5,2,7,21]
	reverse(stack)
	print stack

if __name__ == '__main__':
	main()

