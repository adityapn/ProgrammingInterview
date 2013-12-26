
# This finding the power of a number in log n time
import time

# Efficient way 
def power(x,n):
    # If the number is 0
    if n == 0 :
        return 1
    # If the number is even
    elif n%2 == 0:
        y = power(x,n/2)
        return y*y
    # If the number is odd
    else:
        y = power(x,n-1)
        return x*y


start = time.time()
print power(1000,10000)
end = time.time()
print "O(Log n) method time : "+str(end-start)
