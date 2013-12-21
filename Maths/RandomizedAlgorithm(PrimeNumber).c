/*
  Primalty Testing using Randomized algorithm helps to find prime number in less than O(n)

  Fermats theoram :

	if n is prime number if (a^(n-1))%(n) = 1
*/

#include<stdio.h>

int main()
{
	int n = 10;	
	// it's better if we use sq root of 'n' instead of n/2
	int i = 2;
	for (; i < n/2; ++i)
	{
		int upper = i^(n-1);
		int result = upper%n;
		if (result == 1)
		{
			printf("its prime\n");
			break;
		}		
	}
	
	return 0;
}