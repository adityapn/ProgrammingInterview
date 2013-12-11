package programminginterview;
public class LongestPalindrome {
	//ok a test case
	public static void main(String[] args)
	{
		String in = "5123443218";//expected longest palindrome is "1234321"
		System.out.println("Longest palindrome (naive) "+LongestPalindromeNaive(in));
		System.out.println("Longest palindrome (Improve) "+LongestPalindromeImprove(in));
	}
	
	
	//Now implement the improved method
	public static String LongestPalindromeImprove(String in)
	{
		char[] input = in.toCharArray();
		int longestStart = 0;
		int longestEnd = 0;//we also need global start/end to keep track of the current best as we process
		//now the key is to scan from mid to both ends
		for(int mid=0; mid<input.length;mid++)//we name it as mid for easy interpretation
		{
			//for odd case
			int left = mid;
			int right = mid;//for example 12321 when we choose 3 as mid
			while(left>=0 && right<input.length)//make sure both indexes are valid
			{
				if(input[left]==input[right])//if still palindrome match by one step further each loop cycle
				{
					//we need decide if to update global start/end
					if(right-left>longestEnd-longestStart)//the longer is found!
					{
						longestStart = left;
						longestEnd = right;
					}
				}
				left--;
				right++;//sorry added in wrong place, should be in either case per mid choice
			}
			
			//well for even case we need replicate the previous code by making one change
			left = mid;
			right = mid+1;//for example 123321 when we choose 33 as mid
			while(left>=0 && right<input.length)//make sure both indexes are valid
			{
				if(input[left]==input[right])//if still palindrome match by one step further each loop cycle
				{
					//we need decide if to update global start/end
					if(right-left>longestEnd-longestStart)//the longer is found!
					{
						longestStart = left;
						longestEnd = right;
					}
				}
				left--;
				right++;
			}
			//do not forget to increase right and decresea left!!!
			
		}
		//after the loop we return
		return in.substring(longestStart, longestEnd+1);
		//notice we play with all valid indexes for longestEnd while substring 
		//method return the substring ending before the endindex
	}
	
	
	//now implement first method
	public static String LongestPalindromeNaive(String in)
	{
		//firstly convert string to char array for easy accessing
		char[] input = in.toCharArray();
		int longestStart = 0;
		int longestEnd = 0;
		//now we arbitrarily select start and end
		for(int start=0; start<input.length;start++)
			for(int end=start+1; end<=input.length;end++)//notice we add one to end because substring in java ends with endindex-1
			{
				if(ifPalindrome(input, start, end-1))//in order to use our support method to access char in array, need to adjust the endindex by 1
				{
					//if it is a longer palindrome we update our global longest palindrome
					if(end-start>longestEnd-longestStart)
					{
						longestEnd = end;
						longestStart = start;
					}
				}
			}
		//after the loop we return the longest palindrome
		return in.substring(longestStart, longestEnd);
	}
	
	//before that we implement a support method to decide if a substring a palindrome, we use char[] instead of String as input
	private static boolean ifPalindrome(char[] input, int start, int end)
	{
		//the idea is to scan from 1st to the mid point to see the reverse side char same as the picked one and return
		for(int i=start; i<=(start+end)/2; i++)//notice we use <= other than <
		{
			if(input[i]==input[start+end-i])//the same, continue
				continue;
			else
				return false;
		}
		//if we come here that means it is a palindrome for selected start/end
		return true;
	}
}
