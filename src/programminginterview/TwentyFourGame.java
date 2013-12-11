package programminginterview;

class TwentyFourGame
{
	//test case
	public static void main(String[] args)
	{
		int[] nums = new int[4];
		java.util.Random myRandom = new java.util.Random();
		for(int i=0; i<4; i++)
		{
			nums[i] = myRandom.nextInt(10)+1;//range from 1 to 10
			System.out.print(""+nums[i]+" ");
		}
		System.out.println("\nStart 24 computing: ");
		//nums[0] = 9; nums[1] = 7; nums[2] = 10; nums[3] = 5; 
		TwentyFourResult t = Solve24(nums);
		if(t.success)
			System.out.println("Success: "+t.expression+"=24");
		else
			System.out.println("No way to compute 24");
		//somehow miss parenthesis in this case, need further improvements, try by yourself!
		//should be ((3-2)*3)*8=24

	}

	//now to extend to four numbers!
	//notice we accept integers as they are originally be, and each exp for each number at beginning are themselves
	public static TwentyFourResult Solve24(int[] nums)
	{
		if(nums.length!=4) return new TwentyFourResult(false, "");//make sure it is a 4-number array
		//the idea is to select combination of two numbers, compute result and use 3-number method solve the remaining
		boolean[] used = new boolean[4];//we define a support boolean array to keep track of usage
		for(int i=0; i<4; i++)
		{
			used[i] = true;
			for(int j=i+1; j<4; j++)
			{
				//so position i and j are chosen, we need know the other two numbers
				used[j] = true;
				//do things here
				double b = -1;
				double c = -1;//we define b and c as they are future b.c in 3-number solve24 method
				for(int m=0; m<4;m++)
				{
					if(!used[m])//haven't used
					{
						if(b==-1) 
							b = nums[m];//we set b first
						else
							c = nums[m];
					}
				}

				//the remaining work is to choose two number (nums[i]. nums[j]) and call the 3-num method
				//we also cast the numbers for expression output for better readability
				//need to change integer to String for next processing
				TwentyFourResult t = Solve24(nums[i]+nums[j], b, c, (int)nums[i]+"+"+(int)nums[j], ""+(int)b, ""+(int)c);
				if(t.success) return t;//always return immediately when a solution is found!
				//for the order of number it makes difference if we put the sum at 1st and 3rd position because 
				//for 3-num solve24 method, we only choose first two numbers for computing first
				//thus we need shuffle the order of first number with 3rd and repeat
				t = Solve24(b, c, nums[i]+nums[j], ""+(int)b, ""+(int)c, (int)nums[i]+"+"+(int)nums[j]);
				if(t.success) return t;
				
				//do the same for remaining operations, "-" here
				t = Solve24(nums[i]-nums[j], b, c, (int)nums[i]+"-"+(int)nums[j], ""+(int)b, ""+(int)c);
				if(t.success) return t;
				t = Solve24(b, c, nums[i]-nums[j], ""+(int)b, ""+(int)c, (int)nums[i]+"-"+(int)nums[j]);
				if(t.success) return t;
				t = Solve24(nums[j]-nums[i], b, c, (int)nums[j]+"-"+(int)nums[i], ""+(int)b, ""+(int)c);
				if(t.success) return t;
				t = Solve24(b, c, nums[j]-nums[i], ""+(int)b, ""+(int)c, (int)nums[j]+"-"+(int)nums[i]);
				if(t.success) return t;

				//*
				t = Solve24(nums[i]*nums[j], b, c, (int)nums[i]+"*"+(int)nums[j], ""+(int)b, ""+(int)c);
				if(t.success) return t;
				t = Solve24(b, c, nums[i]*nums[j], ""+(int)b, ""+(int)c, (int)nums[i]+"*"+(int)nums[j]);
				if(t.success) return t;

				//"/" here
				t = Solve24(nums[i]/nums[j], b, c, (int)nums[i]+"/"+(int)nums[j], ""+(int)b, ""+(int)c);
				if(t.success) return t;
				t = Solve24(b, c, nums[i]/nums[j], ""+(int)b, ""+(int)c, (int)nums[i]+"/"+(int)nums[j]);
				if(t.success) return t;
				t = Solve24(nums[j]/nums[i], b, c, (int)nums[j]+"/"+(int)nums[i], ""+(int)b, ""+(int)c);
				if(t.success) return t;
				t = Solve24(b, c, nums[j]/nums[i], ""+(int)b, ""+(int)c, (int)nums[j]+"/"+(int)nums[i]);
				if(t.success) return t;


				//reset used signal
				used[j] = false;
			}
			used[i] = false;//set it back
		}
		//return a default false signal here
		return new TwentyFourResult(false, "");
	}

	//now we extend to three numbers
	private static TwentyFourResult Solve24(double a, double b, double c, String expA, String expB, String expC)
	{
		//System.out.println(expA+"\t"+expB+"\t"+expC);
		//the idea is to arbitrary select first two numbers, compute results and let the defined 2-number method solve remaining
		//also everytime check if success then stop immediately otherwise try more possible solutions
		//try combine a+b
		TwentyFourResult t = Solve24(a+b, c, expA+"+"+expB, expC);
		if(t.success)
			return t;//when we find this works return!
		t = Solve24(a-b, c, expA+"-"+expB, expC);
		if(t.success) return t;
		t = Solve24(b-a, c, expB+"-"+expA, expC);
		if(t.success) return t;
		t = Solve24(a*b, c, "("+expA+")*("+expB+")", expC);
		if(t.success) return t;
		t = Solve24(a/b, c, "("+expA+")/("+expB+")", expC);
		if(t.success) return t;
		t = Solve24(b/a, c, "("+expB+")/("+expA+")", expC);
		if(t.success) return t;

		t = Solve24(a+c, b, expA+"+"+expC, expB);
		if(t.success)
		t = Solve24(a-c, b, expA+"-"+expC, expB);
		if(t.success) return t;
		t = Solve24(c-a, b, expC+"-"+expA, expB);
		if(t.success) return t;
		t = Solve24(a*c, b, "("+expA+")*("+expC+")", expB);
		if(t.success) return t;
		t = Solve24(a/c, b, "("+expA+")/("+expC+")", expB);
		if(t.success) return t;
		t = Solve24(c/a, b, "("+expC+")/("+expA+")", expB);
		if(t.success) return t;
		
		//otherwise return false signal
		return new TwentyFourResult(false, "");//return as a failure
	}


	//as we discussed the way, we start from simplest case, 2 number to compute 24
	//however, one thing to notice we are going to use double instead of integers
	//think about 3,3,7,7 (3+3/7)*7=24, thus we need also a tolerance precision level like 0.001
	//besides we need to remember the expression related to numbers, because some numbers may be computed from multiple numbers
	static double precision = 0.001;
	private static TwentyFourResult Solve24(double a, double b, String expA, String expB)
	{
		//we just try all possible +-*/ combination of two numbers to see if they are equal to 24
		if(Math.abs(a+b-24)<precision)//if sum equals 24
			return new TwentyFourResult(true, expA+"+"+expB);//just return expa+expb
		//repeat this for other operation, notice minus and divide has order so have to repeat for both orders
		if(Math.abs(a-b-24)<precision)
			return new TwentyFourResult(true, expA+"-("+expB+")");//add parenthesis to keep accuracy e.g. 25-(2-1)?
		if(Math.abs(b-a-24)<precision)
			return new TwentyFourResult(true, expB+"-("+expA+")");
		if(Math.abs(a*b-24)<precision)
			return new TwentyFourResult(true, "("+expA+")*("+expB+")");//we add parenthesis in both sub-exps
		if(Math.abs(a/b-24)<precision)
			return new TwentyFourResult(true, expA+"/("+expB+")");
		if(Math.abs(b/a-24)<precision)
			return new TwentyFourResult(true, expB+"/("+expA+")");
		//otherwise
		return new TwentyFourResult(false, "");//return as a failure
	}
}
//firstly define a class to encapsulate the return data (success or not, expression to compute 24)
class TwentyFourResult
{
	boolean success;
	String expression;
	public TwentyFourResult(boolean suc, String exp)
	{
		success = suc;
		expression = exp;
	}
}
