package programminginterview;

class ListRotate 
{
	//let's create a test case
	public static void main(String[] args)
	{
		List myList = new List(1);
		myList.next = new List(2);
		myList.next.next = new List(3);
		myList.next.next.next = new List(4);
		myList.next.next.next.next = new List(5);//so the list is 1,2,3,4,5
		myList.Print();//print out the list should be in order
		myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 3,4,5,1,2
		myList.Print();//let's verify it!
		myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 5,1,2,3,4
		myList.Print();//let's verify it!
	}

	//all right now we implement our rotate method
	public static List RotateN(List myL, int k)//myL is the original list and k is number of rotates
	{
		//as we discussed in slide we need some variables to keep track of
		//1. the tail of final list, or Kth value
		//2. the head of final list, or k+1th node
		//3. we need a current visiting node to keep track of visiting status all the time
		List current = myL;//we start from my list head
		List oldTail;
		List newStart;
		//firstly we try to find the tail of kth value
		while(k>1)//notice we use 1 instead of 0
		{
			current = current.next;
			k--;
		}
		//now the current points to kth value, and the new list's head is its next!
		newStart = current.next;
		//also as the currentNode is the final tail, we need to set its next to null
		current.next = null;
		//next we proceed from the newStart until end (tail of original list) and set the next of tail to myL!!!
		current = newStart;//we update our current by one step further
		while(current.next!=null)
			current = current.next;
		//now we come to the tail of original List, current keeps track of it
		current.next = myL;//myL is the head of original List!
		//finally we return the list starting from newStart
		return newStart;
	}
}
//we firstly define our simple List class
class List
{
	List next;
	int value;
	public List(int k)
	{
		value = k;
	}
	//we also define a print method to print List in order
	public void Print()
	{
		List current = this;
		while(current!=null)
		{
			System.out.print(current.value+"->");
			//gosh I forget to update current index
			current = current.next;
		}
		System.out.print("NULL\n");
	}
}
