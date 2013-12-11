package programminginterview;

class ReversePhrase 
{
	//create a test case
	public static void main(String[] args)
	{
		String inputStr = "Hello World Friends";
		char[] chars = inputStr.toCharArray();
		Reverse(chars);
		System.out.println("After reverse: "+ (new String(chars)));
	}

	//now we define the key method
	public static void Reverse(char[] chars)
	{
		//firstly we reverse all chars
		Reverse(chars, 0, chars.length-1);//notice we use 0 as start and last index as end

		//now we need reverse the order of char per word
		//we need a support variable to know where each word starts
		int wordStart = 0;//initially set as 0
		for(int i=0; i<chars.length; i++)
		{
			//each time we check if char is space, if so, we reverse from wordStart until i-1
			if(chars[i]==' ')
			{
				Reverse(chars, wordStart, i-1);
				//we also need update the wordStart!
				wordStart = i+1;//only possible to start from next char
			}
			else if(i==chars.length-1)//there is a special case that last char is not space thus last word won't be reversed in previous if clause
			{
				Reverse(chars, wordStart, i);//this time the end index is i not i-1 because this is end of phrase
			}
		}
	}

	//we firstly write the support method to reverse chars from stat to end position
	//as the reverse operation will be used multiple times in the core method
	private static void Reverse(char[] chars, int start, int end)
	{
		//we firstly make sure there is need to start the loop for reversal
		if(start>=end)
			return;
		//now we start from start until mid and swap with the other matched char
		for(int i=start; i<=(start+end)/2; i++)//loop stops at mid
		{
			char temp = chars[i];
			chars[i] = chars[start+end-i];//the index position start+end-i is the matched position!
			chars[start+end-i] = temp;
		}
	}
}
