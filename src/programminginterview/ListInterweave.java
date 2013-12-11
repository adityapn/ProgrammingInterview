package programminginterview;

class ListInterweave
{
	//create a test case
	public static void main(String[] args)
	{
		MyList L = new MyList(1);
		L.next = new MyList(2);
		L.next.next = new MyList(3);
		L.next.next.next = new MyList(4);
		L.next.next.next.next = new MyList(5);
		L.next.next.next.next.next = new MyList(6);
		L.next.next.next.next.next.next = new MyList(7);
		L.Print();//expect 1,2,3,4,5,6,7
		Interweave(L);
		L.Print();//expect 1,7,2,6,3,5,4

		//notice this problem we used constant space and linear running time!
	}

	//now we define the method using three support methods
	public static void Interweave(MyList L)
	{
		MyList mid = FindMid(L);
		//now reverse 2nd half
		MyList secondhalf = Reverse(mid.next);
		MyList firsthalf = L;
		//do not forget to update mid.next==null
		mid.next = null;//otherwise we are duplicating L1 and L2
		L = Merge(firsthalf, secondhalf);
	}

	//as the key method for interweaving the linked list involves three steps
	//1. find the mid point
	//2. reverse the 2nd half of list
	//3. merge them in place
	//we are going to define all three supporting methods before declaring the main interweave method

	//first method, to find mid point of array in linear time
	//the trick is using two pointers (fast/slow) until fast meets the null
	private static MyList FindMid(MyList L)
	{
		MyList fast = L;//two steps per move
		MyList slow = L;//one step per move
		while(fast!=null && fast.next!=null && slow!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//2nd support method, to reverse the list
	private static MyList Reverse(MyList L)
	{
		//firstly judge if null or one-node list
		if(L==null || L.next==null)
			return L;
		//otherwise, do it in a recursive manner
		MyList nextReverse = Reverse(L.next);
		L.next.next = L; //L.next is tail of reversed remaining, thus the next can point to L
		L.next = null;//do not forget update L's next
		return nextReverse;
	}

	//so the 3rd method is to merge two lists into one, by picking one from each other
	private static MyList Merge(MyList L1, MyList L2)
	{
		//however, one assumption is that the length of L1>L2, because of our mid algorithm
		MyList merged = new MyList(0);//its next is the resulting merged list
		MyList current = merged;//current points where we are at the time of merging
		int turn = 1;//we define a turn to know which list element to be merged per loop cycle
		while(L1!=null && L2!=null)
		{
			if(turn==1)//pick from L1
			{
				current.next = L1;
				L1 = L1.next;//update L1's index to right
				turn = 2;//next loop we pick from L2
			}
			else//pick from L2
			{
				current.next = L2;
				L2 = L2.next;//update L1's index to right
				turn = 1;//back to L1 next cycle
			}
			current = current.next;//update the current pointer
		}
		//as we said L1's length may be longer than L2 considering size of array
		if(L1!=null)//we merge the remaining L1 to our current.next
			current.next = L1;

		return merged.next;
	}
}
//firstly we reuse our linked list definition
class MyList
{
	int value;
	MyList next;
	public MyList(int k)
	{
		value  = k;
	}
	public void Print()
	{
		MyList tmp = this;
		while(tmp!=null)
		{
			System.out.print(tmp.value+"->");
			tmp = tmp.next;
		}
		System.out.println("NULL");
	}
}
