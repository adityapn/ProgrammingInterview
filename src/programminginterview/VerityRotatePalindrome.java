package programminginterview;
public class VerityRotatePalindrome {
	//lastly create a test case
	public static void main(String[] args)
	{
		String input = "1234321";
		System.out.println(input+"\t A rotated palindrome? "+IfRotatePalindrom(input));
		
		String input2 = "3432112";
		System.out.println(input2+"\t A rotated palindrome? "+IfRotatePalindrom(input2));
		
		String input3 = "234321";
		System.out.println(input3+"\t A rotated palindrome? "+IfRotatePalindrom(input3));
	}
	
	//First, define a palindrome method
	public static boolean IfPalindrome(String in)
	{
		//the idea to verify if a string is a palindrom is to check each pair of chars at position (i, length-1-i)
		//if a mismatch is found return false, otherwise, return true
		char[] ins = in.toCharArray();
		//notice the following loop can be optimized a little by stop at half position! Reason is because (1,3) and (3,1) is the same thing!
		
		for(int i=0; i<=ins.length/2;i++)
		{
			//verify each position pair of (i, length-1-i)
			if(ins[i]!=ins[ins.length-1-i])
				return false;//any mismatch will cause an immediate false signal return
		}
		//if we come here that means the string passed all check for pairs, so it is a palindrome
		return true;
	}
	
	//now we start implement our rotate palindrome algorithm
	public static boolean IfRotatePalindrom(String in)
	{
		//as we discussed in the slides, we split each char string into left+right and check the combination
		//of right+left to see if it is a palindrom
		for(int i=0; i<in.length();i++)
		{
			String left = in.substring(0, i);//the first substring method accepts 2 values, 1st is index, 2nd is length
			String right = in.substring(i);//the overloaded substring method accepts the starting index as the only argument
			//now use our palindrom method to check right+left
			if(IfPalindrome(right+left))
				return true;//immediate return as a true rotated palindrome when we find one
		}
		return false;//do not forget to return a default false value if no true signal is returned
	}
}
