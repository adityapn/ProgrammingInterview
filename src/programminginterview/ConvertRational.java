package programminginterview;

public class ConvertRational {
	//now let's create a test case
	//the code is working, basically, however, there is one case not solven yet, the negative values
	public static void main(String[] args)
	{
		System.out.println(GetRational(0.125));
		System.out.println(GetRational(-0.125));
		System.out.println(GetRational(3.25));
		System.out.println(GetRational(-8.9));
	}
	
	//define method header
	public static String GetRational(double a)
	{
		//firstly we try to find 10^x to make a*10^x an integer value
		boolean ifNegative = a<0;
		a = a<0? -a : a;//choose the positive part only
		int tenPoly = 1;
		while(a*tenPoly - (int)(a*tenPoly) !=0)//sorry made a mistake, only if not equal to zero will we continue :)
			tenPoly*=10; //note, this method is not suitable for all cases, especially if precision is high
		
		//now we find a value that a*tenPoly = an integer value
		int divident = (int)(a*tenPoly);//need cast the double value to interger!
		int divisor = tenPoly;
		
		//next we need find the GCD of divident and divisor
		int gcd = 0;
		if(divident > divisor) gcd = GCD(divident, divisor);
		else gcd = GCD(divisor, divident);
		
		//now improve the divident/divisor by dividing each with gcd
		divident /= gcd;
		divisor /= gcd;
		
		String output = a+" = ";
		if(divisor>0)
			output += divident + "/" + divisor;
		else
			output += "-"+divident + "/" + (0-divisor);
		return ifNegative ? '-'+output : output;//add negative sign if necessary
	}
	
	//defined as private method for supporting method only, define as public for out of class invokation
	//let's assume a>=b
	private static int GCD(int a, int b)
	{
		int remainder = a%b;
		if(remainder == 0)
			return b;
		else
			return GCD(b, remainder);//Eucilidean Algorithm
	}
}
