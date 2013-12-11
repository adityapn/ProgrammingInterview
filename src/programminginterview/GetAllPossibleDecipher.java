package programminginterview;

public class GetAllPossibleDecipher {

        public static void main(String[] args) {
		//let's create a test case
		int[] testCoding = {1,2,3,4};//expect three ways in our slides, 1234, 12|3|4, 1|23|4
		System.out.println("Possible ways: "+GetPossibleDecipherWays(testCoding));
	}
	
	//now define the key method
	static int GetPossibleDecipherWays(int[] codings) {
		//firstly we decipher from end to front, need two values to keep track of last two
		int last1 = 0; int last2 = 0;
		int currentIndex = codings.length-1;
		//firstly check if last digit is valid or not and assign to last 1
		last1 = (isValid(codings,currentIndex))?1:0;
		//now check if last two forms a valid and last 2nd digit itself is valid
		if(isValid(codings, currentIndex-1, currentIndex))
			last2 ++;
		if(isValid(codings, currentIndex-1))
			last2 += last1;//depend on if last digit is valid or not for deciphering
		//update current index
		currentIndex -= 2;//skip the first two
		while(currentIndex>=0) {
			//as we discussed in slides, we need check current and current+(current+) two cases
			int tempWays = 0;
			if(isValid(codings, currentIndex)) 
				tempWays += last2;//we add ways starting from next position
			if(isValid(codings, currentIndex, currentIndex+1))
				tempWays += last1;//if first two forms a valid decipher, add ways starting from next 2 positions
			//update last1 and last2
			last1 = last2;
			last2 = tempWays;
			//finally update the index
			currentIndex--;
		}
		//finally return, as currentIndex equals -1 when loop stops, last2 starts from 0 position!
		return last2;
	}
	
	//firstly define the support methods to decide if valid for current index
	static boolean isValid(int[] codings, int index) {
		return codings[index]!=0;
	}
	
	//define the 2nd support method to decide if (current, current+1) is valid
	static boolean isValid(int[] codings, int index, int index2) {
		//basically to check if this number within 10 to 26;
		int num = 10*codings[index] + codings[index2];//it actually took me 10mins for debugging ^_^
		return num>=10 && num<=26;
	}
}