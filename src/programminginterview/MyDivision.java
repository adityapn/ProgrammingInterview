package programminginterview;


class MyDivision 
{
	//now we create a test case
	public static void main(String[] args)
	{
		//let's use a large number to see the diff of two methods
		System.out.println("Naive: 1000000/2="+NaiveDiv(1000000, 2));
		System.out.println("Opt: 1000000/2="+OptDiv(1000000, 2));
	}

	//now let's compare the performance by comparing how many loops each method is using

	//first let's implement the naive div method
	public static int NaiveDiv(int divident, int divisor)
	{
		int quotient = 0;//return result
		int loopTime = 0;
		while(divident>=divisor)
		{
			loopTime++;
			divident -= divisor;//while the remainder is larger than divisor, we keep subtracting
			quotient++;//do not forget update quotient!
		}
		System.out.println("Naive loop time: "+loopTime);
		return quotient;
	}

	//now we implement the optimized div method
	public static int OptDiv(int divident, int divisor)
	{
		int quotient = 0;
		int loopTime = 0;
		java.util.List<Integer> divisors = new java.util.ArrayList<Integer>();
		java.util.List<Integer> quotients = new java.util.ArrayList<Integer>();
		//now we need some supporting variables to keep track of the increased/decreased divisor and base
		quotients.add(1);
		divisors.add(divisor);
		//now we start our loop, we will use the same criterial as naive div to determine continue or stop
		int currentDivisorIndex = 0;
		while(divident>=divisor)
		{
			loopTime++;
			//instead of use divisor as in naive method, we play with the currentDivisor which is a key to our method
			if(divident>=divisors.get(currentDivisorIndex))//there is space we substract and increase the divisor by doubling!
			{
				//firstly update quotient
				divident -= divisors.get(currentDivisorIndex);
				quotient += quotients.get(currentDivisorIndex);//notice it is not 1 but base
				//also double the current divisor and quotient and add to lists
				divisors.add(divisors.get(currentDivisorIndex)+divisors.get(currentDivisorIndex));
				quotients.add(quotients.get(currentDivisorIndex)+quotients.get(currentDivisorIndex));
				currentDivisorIndex++;
			}
			else//the current divisor may be too large now thus we need decrease it by halving
			{
				currentDivisorIndex--;//do not forget the update base quotient
			}
		}
		System.out.println("Optimized method loop time: "+loopTime);
		return quotient;
	}
}
