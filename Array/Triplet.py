
# When sum of three numbers is zero then it's called as triplet
# There are 3 ways for form this -ve + -ve + +ve = 0 or -ve + +ve + +ve  = 0
# Sort the numbers and divide them into two groups positive numbers group and
# negative numbers group first try with this -ve + -ve + +ve = 0 then try this
# -ve + +ve + +ve = 0 , one of this should form the triplet 


def Triplet(numbers):
    numbers.sort()
    negative = []
    positive = []

    for number in numbers:
        if number < 0:
            negative.append(number)
        else:
            positive.append(number)

    # Code for triplet
    if len(negative) > 1:        
        counter = 0
        final = len(negative) - 1
        while counter < final:            
            tempSum = -(negative[counter] + negative[counter+1])            
            # if for the equivalent +ve sum in positive array
            found = None
            try:
                found = positive.index(tempSum)
            except Exception:
                found = None
            
            if found is not None:
                print "Numbers are "+str(negative[counter])+","+str(negative[counter+1])+" and "+str(positive[found])
                return
            counter += 1

    if len(positive) > 1:
        counter = 0
        final = len(positive) - 1
        while counter < final:            
            tempSum = -(positive[counter] + positive[counter+1])            
            # if for the equivalent +ve sum in positive array
            found = None
            try:
                found = negative.index(tempSum)
            except Exception:
                found = None            
            if found is not None:
                print "Numbers are "+str(positive[counter])+","+str(positive[counter+1])+" and "+str(negative[found])
                return
            counter += 1

        
numbers = [-15,5,10,60,80,100]            
Triplet(numbers)
