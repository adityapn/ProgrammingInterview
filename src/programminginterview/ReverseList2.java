package programminginterview;

public class ReverseList2 {
	//now Let's create a test case
	public static void main(String[] args)
	{
		List myList = new List(1);//create a List
		myList.next = new List(2);//1->2
		myList.next.next = new List(3);//1->2->3
		myList.next.next.next = new List(4);//1->2->3->4
		
		System.out.println(myList.toString());//expect 1->2->3->4
		System.out.println(Reverse(myList).toString());	//expect 4->3->2->1!! Let's run the code
	}
	
	
	
	//first define method header
	public static List Reverse(List L)
	{
		//1. check if we need reverse or not, in case L is empty or has only 1 element
		if(L==null || L.next==null)
			return L;
		//2. now use the recursive way
		List remainingReverse = Reverse(L.next);
		
		//3. we need find the tail of the remainingReverse and update the tail as our beginning
		//element
		List cur = remainingReverse;
		while(cur.next!=null)
			cur = cur.next;
		
		//now cur.next==null and this is the tail position
		cur.next = L;//we assign our beginning element in original List to reversed List tail
		
		//Do not forget update our beginning element L's next to null
		L.next = null;
		
		//Last step, return the reversed List
		return remainingReverse;
	}
}

//This is the given List class definition
class RLList2{
	int value;
	RLList2 next;
	public RLList2(int k)
	{
		value = k;
		next = null;
	}
	
	public String toString()
	{
		RLList2 cur = this;
		String output = "";
		while(cur!=null)
		{
			output+=cur.value+"-->";
			cur = cur.next;
		}
		return output+"TAIL";
	}
}
