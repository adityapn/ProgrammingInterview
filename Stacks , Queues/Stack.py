'''
You have to give a data structure to implement push & pop 
(as like a simple satck ) in O(1) time & find minimum 
of the current stack also in O(1) time
'''

class Stack:
	li = None
	top = None
	

	def push(self,data):
		if self.li is None:
			self.li = []
			self.li.append(data)
			self.top = data			
		else:
			if data > self.top:
				temp = self.top
				self.li.pop()
				self.li.append(data)
				self.li.append(temp)
			else:
				self.li.append(data)
				self.top = data

	def pop(self):
		one =  self.li.pop()		
		if self.li is None:
			return one
		two = self.li.pop()		
		if one < two :
			return one
		
		return two




def main():
	stack = Stack()
	stack.push(1)
	stack.push(2)
	stack.push(3)
	stack.push(4)
	stack.push(8)

	for i in range(0,5):
		print stack.pop()

if __name__ == '__main__':
	main()
