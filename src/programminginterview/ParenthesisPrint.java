package programminginterview;

class  ParenthesisPrint
{
	//now let's create a test case
	public static void main(String[] args)
	{
		//PrintParenthesis(3,3,"");//test print all valid combinations of 3 groups of parenthesis

		PrintParenthesis(3,3,"");//try 5 groups
	}


	//define method header
	//left and right remains are keeping track of how many remaining parenthesis left for printing
	//currentString is used to keep track of the current printout for each recursive call
	public static void PrintParenthesis(int leftRemain, int rightRemain, String currentString)
	{
		//firstly check if there is need to go further
		if(rightRemain==0)//all printed out
		{	
			System.out.println(currentString);
			return;
		}
		//now coming to the recursive part
		if(leftRemain>0)//more left parenthesis left for printing
		{
			//choice 1, print another left parenthesis
			PrintParenthesis(leftRemain-1, rightRemain, currentString+"(");
			//choice 2, print right parenthesis if valid
			if(leftRemain < rightRemain)//which means more left parenthesis have been used 
				PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
		}
		else//now there are only right parenthesis left
			PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
	}
}
