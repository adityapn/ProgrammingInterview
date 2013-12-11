package programminginterview;

class ListIntersection 
{
	//let's create a test case
	public static void main(String[] args)
	{
		LList common = new LList(10);
		common.next = new LList(11);//common intersection sub-list is 10>11
		LList list1 = new LList(1);
		list1.next = new LList(2);
		list1.next.next = new LList(3);//first list starts with 1>2>3
		list1.next.next.next = common;//this list is 1>2>3>10>11

		LList list2 = new LList(7);
		list2.next = new LList(8);
		list2.next.next = common;//so the length is 7>8>10>11

		list1.Print();
		list2.Print();
		System.out.println("Intersection of two lists starts from " + Intersection(list1, list2).value);

	}
	//now we define our improved method, naive method is simple so try yourself
	//method head accept two lists and return a list
	public static LList Intersection(LList a, LList b)
	{
		//as we discussed in slide, the first step is to find the diff of lengths of two lists
		int aLength = 0;
		int bLength = 0;
		LList cur = a;//cur is the pointer used to keep track of current focus node
		while(cur!=null)
		{
			aLength++;
			cur = cur.next;
		}
		//after the previous loop, aLength records the length of list a
		cur = b;//we copy the code with slight modification to get length of list b
		while(cur!=null)
		{
			bLength++;
			cur = cur.next;
		}
		//all right we get list a and b's lengths
		//next we do some node skipping if the lengths are not equal
		if(aLength>bLength)//there are more nodes in List a
		{
			for(int i=0; i<aLength-bLength; i++)
				a = a.next;
		}//after this scope of code for cases that list a is longer than b, 
		//we skipped the necessary nodes to make the remaining a and b equal length
		else if(bLength>aLength)//do the same for list b if length b larger than a
		{
			for(int i=0; i<bLength-aLength; i++)
				b = b.next;
		}
		//now we are pretty sure the remaining a and b are equal length 
		//(check our slide example, we will skip the first node in list a
		while(a!=b && a!=null && b!=null)//make sure these two lists are not null
		{
			a = a.next;
			b = b.next;//we keep the same pace by scanning both lists to its next together
		}
		//after that loop, a=b and it is the value we are searching for!
		return a;//the point is where a=b and that's the intersection point!
	}
}
//firstly we reuse the list definition in previous examples
class LList
{
	LList next;
	int value;
	public LList(int k)
	{
		value = k;
	}
	public void Print()
	{
		LList current = this;
		while(current!=null)
		{
			System.out.print(current.value+"->");
			current = current.next;
		}
		System.out.print("NULL\n");
	}
}
