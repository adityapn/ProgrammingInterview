package programminginterview;

class GuessingPassRate 
{
	//let's test
	public static void main(String[] args)
	{
		System.out.println("Ratio of guessing 5 out of 10 is " +passingRatio(10, 5));
		System.out.println("Ratio of guessing 2 out of 4 is " +passingRatio(4, 2));
	}

	//define the key method
	//N is the total number of 4-choice questions
	//k is the number of correct ones after guessing
	public static double passingRatio(int N, int k)
	{
		//we firstly define the ratios for 1-question case
		double singleCorrect = 1.0/4;
		double singleWrong = 3.0/4;

		//in order to use dynamic programming to process problem from bottom up
		//we need additional storage to memorize the data for smaller cases
		double[][] ratios = new double[N+1][k+1];//notice the size is enlarged per 1 per row/column size
		//also notice we only need stop at k per N case because more questions corrrectly guessed is no use for us
		//before the loop, we assign values
		ratios[1][0] = singleWrong;//1 means 1 question, 0 means 0 correct, so ratios[i][j] means j out i are correct
		ratios[1][1] = singleCorrect;

		for(int i=2; i<=N; i++)
		{
			for(int j=0; j<=k; j++)
			{
				//before that there is a special case when j==0 no correct answer at all
				if(j==0)
					ratios[i][j] = ratios[i-1][j]*singleWrong;
				else
					ratios[i][j] = ratios[i-1][j-1]*singleCorrect //(j-1) out of (i-1) are correct, thus last one requires correct
									+ ratios[i-1][j]*singleWrong; //j out of (i-1) are already correct, thus last one requires incorrect
			}
		}

		return ratios[N][k];
	}
}
