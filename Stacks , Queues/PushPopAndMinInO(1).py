# Doing push() , pop() , getMin() in O(1)

min_stack = []
count = 0
stack = []

def pop():
    global count
    elements = None
    if stack is not None:
        elements = stack.pop()
        min_stack.pop()
        count = count - 1

    return elements

def push(num):
    global count
    if not stack and not min_stack:        
        stack.append(num)
        min_stack.append(num)        
        return
    if num < min_stack[count]:
        min_stack.append(num)
    else:
        min_stack.append(min_stack[count])
    count = count + 1
    stack.append(num)    

def getMin():
    global count
    if count > -1:
        if min_stack[count] < stack[count]:
            return min_stack[count]
        return stack[count]
    
    
numbers = [18,19,29,15,16]
for number in numbers:
    push(number)

print(" Min "+str(getMin())+" Pop : "+str(pop()))
print(" Min "+str(getMin())+" Pop : "+str(pop()))
print(" Min "+str(getMin())+" Pop : "+str(pop()))
print(" Min "+str(getMin())+" Pop : "+str(pop()))
print(" Min "+str(getMin())+" Pop : "+str(pop()))
