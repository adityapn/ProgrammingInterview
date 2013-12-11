package programminginterview;

class FindShiftInRotatedArray 
{
	public static void main(String[] args)
	{
		int rotates[] = {3,4,5,1,2};
		System.out.println("Rotate by "+FindRotation(rotates));

		int rotates2[] = {3,4,5,6,2};
		System.out.println("Rotate by "+FindRotation(rotates2));

		int rotates3[] = {3,4,5,6,7};
		System.out.println("Rotate by "+FindRotation(rotates3));

		int rotates4[] = {4,5,1,2,3};
		System.out.println("Rotate by "+FindRotation(rotates4));
	}

	//method header, this time we define a iterative method instead of recursive method
	public static int FindRotation(int[] rotates)
	{
		//as we discussed in slides, the key is to use a binary-search similar way to fast-find rotation place
		int start = 0;
		int end =  rotates.length-1;//basically you can imagine we use a recursion-similar way but use loop to process

		//now the key for keep processing is before start index meets our end index
		while(start<end)
		{
			//as we say the other criterial to determine stopping the process is the sub-array is sorted!
			if(rotates[start] < rotates[end])//e.g. {1,2,3,4,5}
				return end+1;//notice end is the key position for output the rotation, and in our case, the length-5 array rotates by 5, thus it is equal to itself
			else
			{
				//binary-search based key process
				int mid = (start+end)/2;
				//ok now we check if the perfect cut-point is found
				//what is perfect cut-point? Think about {3,4,5,1,2} and we choose 5 then {3,4} and {1,2} are sorted!, thus we rotated by 3
				if(rotates[start]<=rotates[mid] && rotates[mid+1]<=rotates[end])
					return mid+1;//here it is mid position we want to output, however, plus one is because index starts with 0
				else if(rotates[start]<=rotates[mid])//if left half is sorted, thus the key is keep process in right half
					start = mid+1;//similar as binary search to shrink the focus window
				else//need keep track of left sub-array
					end = mid - 1;
			}
		}
		//the system should already print out index in the loop, if coming here return an error
		return -1;
	}
}

