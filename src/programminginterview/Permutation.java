package programminginterview;

class Permutation 
{
	//now test the code
	public static void main(String[] args)
	{
		//PrintPermutation("123".toCharArray(), 0);
		//test if duplicates
		PrintPermutation("1234".toCharArray(), 0);
	}

	//define method header
	//notice currentFocus is the key to keep track of the current status
	public static void PrintPermutation(char[] inputs, int currentFocus)
	{
		//before start, check if currentFocus comes to the last char
		if(currentFocus==inputs.length-1)
		{
			System.out.println(new String(inputs));
			return;
		}

		//now firstly keep the current char order in the array and proceed to next
		PrintPermutation(inputs, currentFocus+1);

		//now need swap each next char with currentFocus
		for(int i=currentFocus+1; i<inputs.length; i++)
		{
			//swap the char pair of position (currentFocus, i)
			//in order to remove the duplicates, the key is to check if the two char unequal before swapping!
			boolean ifAppear = false;
			for(int j=0; j<i;j++)
			{
				if(inputs[j]==inputs[i])
				{
					ifAppear = true;
					break;
				}
			}

			if(ifAppear)
				continue;
			Swap(inputs,currentFocus, i);
			PrintPermutation(inputs, currentFocus+1);
			Swap(inputs,currentFocus, i);
		}
	}

	private static void Swap(char[] inputs, int a, int b)
	{
		char temp = inputs[a];
		inputs[a] = inputs[b];
		inputs[b] = temp;
	}
}
