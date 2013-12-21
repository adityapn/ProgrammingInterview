def factorial(number):
    result = 1
    while number > 0:
        result = result * number
        number = number - 1

    return result

def combinational(n,r):
    numerator = factorial(n)
    rf = factorial(r)
    nr = factorial(n-r)
    denominator = rf*nr
    result =  numerator/denominator

    return result 

def main():
    num_cases = int(raw_input("Number of test cases  "))
    numerator = int(raw_input("Numerator (n) "))
    r = int(raw_input("Value of (r) "))
    print combinational(numerator,r)

if __name__ == "__main__":main()
        
