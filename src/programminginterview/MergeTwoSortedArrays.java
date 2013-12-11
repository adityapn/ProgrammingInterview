package programminginterview;

public class MergeTwoSortedArrays {
	
	//now we create a test case
	public static void main(String[] args)
	{
		int[] longArray = {1,3,5,7,0,0,0,0};
		int used = 4;//first 4 values are useful
		System.out.println("Before merging we have "+used+" values in the array");
		for(int i: longArray)
			System.out.print(i+" ");
		int[] shortArray = {2,4,6};
		used = Merge(longArray, shortArray, used);
		System.out.println("After merging we have "+used+" values in the array");
		for(int i: longArray)
			System.out.print(i+" ");
	}
	
	//we define the method
	//we passed three arguments, the first two are the two arrays
	//The longused is to represent how many items are used in the longArray
	//This method returns a int value representing how many valid items to be counted in the merged long array
	public static int Merge(int[] longArray, int[] shortArray, int longUsed)
	{
		//firstly we define two index values to represent the tail of each array
		int longTail = longUsed-1;
		int shortTail = shortArray.length-1;//all values in short array will be used
		//now we need merge, and the order is to merge from end to beginning
		while(longTail>=0 && shortTail>=0)//make sure both arrays have more to merge
		{
			//check which one in the two arrays should be put at this current tail position
			if(longArray[longTail]>shortArray[shortTail])
			{
				//which means at this position, we'd better to put the value in the longArray for the merged array
				longArray[longTail+shortTail+1] = longArray[longTail];
				//Notice the key here for the final index in the merged array!
				//LongTail+shorttail+1 will be the final index, thinking that both tail indexes start from 0
				
				longTail--;//after we put one value in longarray, we need shift our focus to the left a little
			}
			else
			{
				//similarly, we do the same thing for the opposite case
				longArray[longTail+shortTail+1] = shortArray[shortTail];
				shortTail--;
			}
		}
		//are we almost done? Not yet, one tail may not be equal to 0
		//case 1, longTail not equal to 0? No problem, they are in position already!!!
		//case 2, shortTail not equal to 0? We need add element one by one to the final array
		while(shortTail>=0)
		{
			longArray[shortTail] = shortArray[shortTail];//notice the final merging is same as copying
			shortTail--;//do not forget updating the index
		}
		//last step. return how many used elements in the new merged array
		return shortArray.length+longUsed;
	}
}
